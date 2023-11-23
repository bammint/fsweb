package com.shop.service;

import com.shop.dto.OrderDto;
import com.shop.dto.OrderHistDto;
import com.shop.dto.OrderItemDto;
import com.shop.entity.*;
import com.shop.repository.ItemImgRepository;
import com.shop.repository.ItemRepository;
import com.shop.repository.MemberRepository;
import com.shop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemImgRepository itemImgRepository;

    public Long order(OrderDto orderDto, String email){
        Item item = itemRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email);
        // 현재 로그인한 회원의 이메일 정보를 이용해서 회원 정보를 조회

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
        // 주문할 상품 엔티티와 주문수량을 이용하여 주문 상품 엔티티
        orderItemList.add(orderItem);
        Order order = Order.createOrder(member, orderItemList);
        // 회원정보와 주문할 상품 리스트 정보를 이용하여 주문 엔티티 생성
        orderRepository.save(order);
        return order.getId();
    }

    @Transactional(readOnly = true)
    // OrderService 클래스 자체에 @Transactional이 적용되어 있으므로
    // 데이터를 읽기만 하는 메서드에서는 @Transactional 이 적용되어 데이터를 읽어들이는 시간을 없애기위해
    // @Transactional(readOnly = true) 을 적용하여 @Transactional을  제외시킨다.
    public Page<OrderHistDto> getOrderList(String email, Pageable pageable){
       List<Order> orders = orderRepository.findOrders(email,pageable);
       // 유저 아이디와 페이징 조건을 이용해서 주문 목록 조회
       Long totalCount = orderRepository.countOrder(email);
       // 유저의 주문 총 개수를 구함
       List<OrderHistDto> orderHistDtos = new ArrayList<>();
       for(Order order : orders){
           // 주문 리스트를 순회하면서 구매 이력 페이지에 전달할 Dto를 생성
            OrderHistDto orderHistDto = new OrderHistDto(order);
            List<OrderItem> orderItems = order.getOrderItems();
            for(OrderItem orderItem : orderItems){
                ItemImg itemImg = itemImgRepository.findByItemIdAndRepimgYn(orderItem.getItem().getId(),"Y");
                // 주문 상품의 대표 이미지를 조회
                // 주문 상품이 대표 이미지를 조회하여 parameter로 넘기는 ItemId와 repImgYn 를 충족하는 itemImg를 가져온다.
                OrderItemDto orderItemDto = new OrderItemDto(orderItem,itemImg.getImgUrl());
                orderHistDto.addOrderItemDto(orderItemDto);
            }
            orderHistDtos.add(orderHistDto);
       }
       return new PageImpl<OrderHistDto>(orderHistDtos,pageable,totalCount);
       // 페이지 구현객체를 생성하여 반환함
    }


    public boolean validateOrder(Long orderId, String email) {
        Member curMember = memberRepository.findByEmail(email);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        Member saveMember = order.getMember();

        if(!StringUtils.equals(curMember.getEmail(), saveMember.getEmail())){
            return false;
        }
        return true;
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(EntityNotFoundException::new);
        order.cancelOrder();
    }
}

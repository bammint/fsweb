package com.example.member.order;

import com.example.member.entity.Lodging;
import com.example.member.entity.Member;
import com.example.member.repository.LodgingRepository;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final LodgingRepository lodgingRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    public Long order(OrderDto orderDto,String email){
        Lodging lodging = lodgingRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email)
                .orElse(null);

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(lodging);
        orderItemList.add(orderItem);

        Order order = Order.createOrder(member,orderItemList);
        orderRepository.save(order);
        return order.getId();
    }
}

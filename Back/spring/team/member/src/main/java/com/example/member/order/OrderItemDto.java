package com.example.member.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    public OrderItemDto(OrderItem orderItem,String imgUrl){
        this.itemNm = orderItem.getLodging().getName();
        this.orderPrice = orderItem.getOrderPrice();
        this.imgUrl = imgUrl;
    }

    private String itemNm; // 상품명
    private String orderPrice; // 주문 금액
    private String imgUrl; // 상품 이미지 경로
}

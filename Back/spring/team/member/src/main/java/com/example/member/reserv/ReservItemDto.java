package com.example.member.reserv;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservItemDto {
    public ReservItemDto(ReservItem reservItem, String imgUrl){
        this.itemNm = reservItem.getLodging().getName();
        this.orderPrice = reservItem.getOrderPrice();
        this.imgUrl = imgUrl;
    }

    private String itemNm; // 상품명
    private String orderPrice; // 주문 금액
    private String imgUrl; // 상품 이미지 경로
}

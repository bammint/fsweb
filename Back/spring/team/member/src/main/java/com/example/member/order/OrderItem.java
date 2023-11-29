package com.example.member.order;

import com.example.member.entity.BaseEntity;
import com.example.member.entity.Lodging;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Lodging lodging;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private String orderPrice;

    public static OrderItem createOrderItem(Lodging lodging){
        OrderItem orderItem = new OrderItem();
        orderItem.setLodging(lodging);
        orderItem.setOrderPrice(lodging.getPrice());

        return orderItem;
    }
}

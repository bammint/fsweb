package com.example.member.reserv;

import com.example.member.entity.BaseEntity;
import com.example.member.lodging.Lodging;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ReservItem extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Lodging lodging;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Reserv reserv;

    private String orderPrice;

    public static ReservItem createOrderItem(Lodging lodging){
        ReservItem reservItem = new ReservItem();
        reservItem.setLodging(lodging);
        reservItem.setOrderPrice(lodging.getPrice());

        return reservItem;
    }
}

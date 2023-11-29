package com.example.member.order;

import com.example.member.entity.BaseEntity;
import com.example.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private String chkIn; // 체크인 시간
    private String chkOut;  // 체크 아웃 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;  // 오더 주체가 되는 Member

    @CreatedDate
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,
                orphanRemoval = true,fetch = FetchType.LAZY)
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public static Order createOrder(Member member,List<OrderItem> orderItemList){
        Order order = new Order();
        order.setMember(member);
        for(OrderItem orderItem : orderItemList){
            order.addOrderItem(orderItem);
        }
        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

}

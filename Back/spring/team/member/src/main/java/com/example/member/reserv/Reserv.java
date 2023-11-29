package com.example.member.reserv;

import com.example.member.entity.BaseEntity;
import com.example.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserv extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id; // 예약 id

    @JoinColumn(name = "member_id")
    private Member member;  // 오더 주체가 되는 Member

    @Column
    private Long lodgingId; // 숙소 id

    @Column
    private Long roomId; // 방 id

    @Column
    private String name; // 예약자 이름

    @Column
    private String phoneN1; // 예약자 전화번호

    @CreatedDate
    private LocalDateTime orderDate; // 주문일

    @Enumerated(EnumType.STRING)
    private ReservStatus reservStatus; // 주문 상태





    @OneToMany(mappedBy = "reserv",fetch = FetchType.LAZY)
    private List<ReservItem> reservItems = new ArrayList<>();

    public void addOrderItem(ReservItem reservItem){
        reservItems.add(reservItem);
        reservItem.setReserv(this);
    }

    public static Reserv createOrder(Member member, List<ReservItem> reservItemList){
        Reserv reserv = new Reserv();
        reserv.setMember(member);
        for(ReservItem reservItem : reservItemList){
            reserv.addOrderItem(reservItem);
        }
        reserv.setReservStatus(ReservStatus.RESERV);
        reserv.setOrderDate(LocalDateTime.now());
        return reserv;
    }

}

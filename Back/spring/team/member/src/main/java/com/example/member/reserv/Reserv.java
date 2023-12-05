package com.example.member.reserv;

import com.example.member.constant.ReservationStatus;
import com.example.member.entity.BaseEntity;
import com.example.member.entity.Lodging;
import com.example.member.entity.Member;
import com.example.member.entity.Room;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reserv")
@Getter
@Setter
public class Reserv extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 예약 id

    @ManyToOne(fetch = FetchType.LAZY) // 멤버가 주
    @JoinColumn(name = "member_id")
    private Member member;  // reserv 주체가 되는 Member


    @JoinColumn(name = "lodging_id")
    @ManyToOne(fetch = FetchType.LAZY) // 숙소가 주
    private Lodging lodging; // 숙소 id



    @JoinColumn(name = "room_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;


    @Column
    private String reservName; // 예약자 이름
    @Column
    private String reservPN; // 예약자 전화번호

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus; // 예약 상태


    // Cannot invoke "com.example.member.entity.Room.getLodging()" because the return value of "com.example.member.reserv.ReservDto.getRoom()" is null
    // 겟 룸이 널이다

    // 컨트롤러에서 Pathvariable 활용 방법?
    // 예약페이지에 roomId로 정보들을 불러왔지만 roomId를 담아오는건 없다?
    // 이 디티오가 담아오는 디티오가 아닌가? 아닌데

    // 예약 생성
    public static Reserv createReserv(ReservDto reservDto){
        Reserv reserv = new Reserv();
        reserv.setRoom(reservDto.getRoom());
        reserv.setMember(reservDto.getMember());
        reserv.setLodging(reservDto.getRoom().getLodging());
        reserv.setReservName(reservDto.getReservName());
        reserv.setReservPN(reservDto.getReservPN());
        reserv.setReservationStatus(ReservationStatus.RESERVED);
        //System.out.println("reserv: " + reserv);
        return reserv;
    }

    // 예약 취소
    public void cancelReserv() {
        this.reservationStatus = ReservationStatus.AVAILABLE;
    }

}

package com.example.member.lodging;

import com.example.member.entity.BaseEntity;
import com.example.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="lodging")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Lodging extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lodging_id")
    private Long id;

    @JoinColumn(name = "room_id")
    @ManyToOne(fetch = FetchType.LAZY)
//    @OneToMany(fetch = FetchType.LAZY)
    private Room room;  // 숙소 -> 방

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;  // 예약자

//    @Column
//    private Review review;

    @Column
    private String name;    //업체 명

    @Column
    private String detail;  // 상세정보

    @Column
    private String price;   // 가격(선택한 방의 가격을 가져와 대입)

    @Column
    private String location;    // 위치

    @Enumerated(EnumType.STRING)
    private LodgingType lodgingType;    //숙소 타입

    // 매개변수 Room 추가 고려
    public static Lodging toLodging(Member member, LodgingDto lodgingDto) {
        Lodging lodging = new Lodging();
        lodging.setId(lodgingDto.getId());
//        lodging.setRoom(lodgingDto.getRoom());
        lodging.setMember(member);
        lodging.setName(lodgingDto.getName());
        lodging.setDetail(lodgingDto.getDetail());
        lodging.setPrice(lodgingDto.getRoom().getPrice());
        lodging.setLocation(lodgingDto.getLocation());
        lodging.setLodgingType(lodgingDto.getLodgingType());
//        lodging.setRegTime(lodgingDto.getRegTime());
//        lodging.setUpdateTime(LocalDateTime.now());
        return lodging;
    }



}

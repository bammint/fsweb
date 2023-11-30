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
    private Room room;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

//    @Column
//    private Review review;

    @Column
    private String name;

    @Column
    private String detail;

    @Column
    private String price;

    @Column
    private String location;

    @Enumerated(EnumType.STRING)
    private LodgingType lodgingType;

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

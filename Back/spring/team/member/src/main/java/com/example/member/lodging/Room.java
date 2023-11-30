package com.example.member.lodging;

import com.example.member.reserv.ReservStatus;
import com.example.member.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="room")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Room extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReservStatus reservStatus;

    @Column
    private String name;

    @Column
    private String detail;

    @Column
    private String price;

    @Column
    private String checkInTime;

    @Column
    private String checkOutTime;




}

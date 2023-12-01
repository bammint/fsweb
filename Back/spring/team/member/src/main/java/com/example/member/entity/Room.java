package com.example.member.entity;

import com.example.member.constant.ReservationStatus;
import com.example.member.dto.RoomDto;
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

    @JoinColumn(name = "lodging_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lodging lodging;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

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

    public static Room toRoom(RoomDto roomDto, Lodging lodging) {
        Room room = new Room();
        room.setId(roomDto.getId());
        room.setLodging(lodging);
        room.setReservationStatus(roomDto.getReservationStatus());
        room.setName(roomDto.getName());
        room.setDetail(roomDto.getDetail());
        room.setPrice(roomDto.getPrice());
        room.setCheckInTime(roomDto.getCheckInTime());
        room.setCheckOutTime(roomDto.getCheckOutTime());

        return room;
    }

    // Entity 병합용

}

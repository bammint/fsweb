package com.example.member.reserv;

import com.example.member.entity.Lodging;
import com.example.member.entity.Member;
import com.example.member.entity.Room;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservDto {

    private Long id; // 예약 id

    private Long lodgingId; // 숙소 id

    private Long roomId; // 방 id

    @NotEmpty(message = "성명을 입력해주세요")
    private String name; // 예약자 이름

    @NotEmpty(message = "휴대폰번호를 입력해주세요")
    private String phoneN1; // 예약자 전화번호


    public static ReservDto toReservDto(Reserv reserv, Lodging lodging,Room room,Member member){
        ReservDto reservDto = new ReservDto();

        reservDto.setId(reserv.getId());
        reservDto.setLodgingId(lodging.getId());
        reservDto.setRoomId(room.getId());
        reservDto.setName(member.getName());
        reservDto.setPhoneN1(member.getPhoneN1());

        return reservDto;
    }

}

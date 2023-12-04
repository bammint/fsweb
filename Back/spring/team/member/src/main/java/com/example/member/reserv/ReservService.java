package com.example.member.reserv;

import com.example.member.constant.ReservationStatus;
import com.example.member.entity.ItemImg;
import com.example.member.entity.Lodging;
import com.example.member.entity.Member;
import com.example.member.entity.Room;
import com.example.member.repository.LodgingImgRepository;
import com.example.member.repository.LodgingRepository;
import com.example.member.repository.MemberRepository;
import com.example.member.repository.RoomRepository;
import com.example.member.reservItem.ReservItem;
import com.example.member.reservItem.ReservItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservService {
    private final LodgingRepository lodgingRepository;
    private final MemberRepository memberRepository;
    private final ReservRepository reservRepository;
    private final LodgingImgRepository lodgingImgRepository;
    private final RoomRepository roomRepository;

    public ReservDto newReserv(Long roomId, Principal principal) throws Exception{
        ReservDto reservDto = new ReservDto();
        Room room = roomRepository.findById(roomId)
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(principal.getName())
                .orElseThrow(EntityNotFoundException::new);

        reservDto.setRoom(room); // room id
        reservDto.setMember(member); // member email
        return reservDto;
    }
//        th:object="ReservDto";
//
//        th:field="${ReservDto.member.name}"
//        th:field="*{member.name}"
//        // 숙소명 찾기
//        Lodging lodging = reservService.reservLodging(roomId);
//        String lodgingName = lodging.getName();
//        // 방 이름, 디테일, 체크인아웃티임, 가격 찾기
//        Room room = reservService.reservRoom(roomId);
//        String roomName = room.getName();
//        String roomDetail = room.getDetail();
//        String roomCheckInTime = room.getCheckInTime();
//        String roomCheckOutTime = room.getCheckOutTime();
//        String roomPrice = room.getPrice();
//        // 예약자의 이름, 전화번호 찾기
//        Member member = reservService.reservMember(principal);
//        String reservName = member.getName();
//        String reservPN = member.getPhoneN1()+"-"+member.getPhoneN2()+"-"+member.getPhoneN3();
//
//        model.addAttribute("lodgingName", lodgingName);
//        model.addAttribute("roomName", roomName);
//        model.addAttribute("roomDetail",roomDetail);
//        model.addAttribute("roomCheckInTime",roomCheckInTime);
//        model.addAttribute("roomCheckOutTime",roomCheckOutTime);
//        model.addAttribute("roomPrice",roomPrice);
//        model.addAttribute("reservName",reservName);
//        model.addAttribute("reservPN",reservPN);

    public Reserv saveReserv(ReservDto reservDto){
        Reserv reserv = Reserv.createReserv(reservDto);
        validateDuplicateMember(reserv);
        reservRepository.save(reserv);
        reserv.setReservationStatus(ReservationStatus.RESERVED);
        return reserv;

    }

    // 예약하려는 방의 상태를 가져와 예약 가능인지 검증
    private void validateDuplicateMember(Reserv reserv){
        Room reservRoom = roomRepository.findById(reserv.getRoom().getId())
                .orElseThrow(EntityNotFoundException::new);

        if(reservRoom.getReservationStatus().equals("RESERV")){
            throw new IllegalStateException("이미 예약된 숙소입니다");
        }
    }

    // 예약 리스트 만들기


    // Controller로 부터 ReservId를 넘겨받아
    // 예약한 숙소의 상태를 변경 시키는 Reserv의 cancelReserv() 메서드 호출
    public void cancelReserv(Long reservId) {
        Reserv reserv = reservRepository.findById(reservId)
                .orElseThrow(EntityNotFoundException::new);
        reserv.cancelReserv();
    }


    public String findName(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(EntityNotFoundException::new);
        String memberName = member.getName();
        return memberName;

    }

        // 숙소명, 방이름, 방디테일, 체크인아웃, 방가격,   예약자의 이름,전화전호
    public Lodging reservLodging(Long roomId) {
        // 숙소명 찾기
        Lodging lodging = (Lodging) roomRepository.findAllByLodgingId(roomId);
        return lodging;
    }
    public Room reservRoom(Long roomId) {
        // 방 이름, 디테일, 체크인아웃티임, 가격 찾기
        Room room = roomRepository.findById(roomId)
                .orElseThrow(EntityNotFoundException::new);
        return room;
    }
    public Member reservMember(Principal principal) {
        // 예약자의 이름, 전화번호 찾기
        // String.valueOf() 해당 타입 파라미터의 값을 문자열로 변환해준다 NullPointerException 방지
        Member member = memberRepository.findByEmail(String.valueOf(principal))
                .orElseThrow(EntityNotFoundException::new);
        return member;
    }


    // 주문 내역 조회 시 필요한 데이터
    // reservID,숙소네임,숙소 대표이미지, roomId,룸 네임 , memberId, reservName,
    // reservPN,방가격, 예약날짜, 상태, 체크인아웃, 인원(?),

    // room
    // 숙소네임,숙소 대표이미지, roomId,룸 네임,방가격,상태, 체크인아웃, 인원(?)

    // reserv
    // reservId, reservName, reservPN, 예약날짜

    // member
    // memberId

    public List<ReservDto> reservDtoList(){
        List<Reserv> reservList = reservRepository.findAll();
        List<ReservDto> reservDtoList = new ArrayList<>();

        for(Reserv reserv : reservList){
            ReservDto reservDto = ReservDto.toReservDto(reserv);
            reservDtoList.add(reservDto);
        }
        return reservDtoList;
    }

    public boolean validateCancelReserv(Long reservId,String email) {
        Member member = memberRepository.findByEmail(email).orElse(null);
        Reserv reserv = reservRepository.findById(reservId).orElse(null);

        if(StringUtils.equals(member, reserv.getMember().getEmail())){
            return
        }
    }
}

package com.example.member.reserv;

import com.example.member.lodging.Lodging;
import com.example.member.entity.Member;
import com.example.member.lodging.LodgingRepository;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservService {
    private final LodgingRepository lodgingRepository;
    private final MemberRepository memberRepository;
    private final ReservRepository reservRepository;

    public Long order(ReservDto reservDto, String email){
        Lodging lodging = lodgingRepository.findById(reservDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(email)
                .orElse(null);

        List<ReservItem> reservItemList = new ArrayList<>();
        ReservItem reservItem = ReservItem.createOrderItem(lodging);
        reservItemList.add(reservItem);

        Reserv reserv = Reserv.createOrder(member, reservItemList);
        reservRepository.save(reserv);
        return reserv.getId();
    }
}

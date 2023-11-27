package com.example.member.service;

import com.example.member.dto.MemberDto;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDto memberDto) {
        // 1. dto -> entity 변환
        // 2. repository의 save메서드 호출
        Member member = Member.toMemberEntity(memberDto);
        memberRepository.save(member);
        // repository의 save메서드 호출 (조건. entity객체를 넘겨줘야함)
    }
}

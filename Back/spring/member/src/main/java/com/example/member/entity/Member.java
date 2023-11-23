package com.example.member.entity;

import com.example.member.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class Member {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) // unique 제약조건 추가
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    public static Member toMemberEntity(MemberDto memberDto){
        Member member = new Member();
        member.setMemberEmail(memberDto.getMemberEmail());
        member.setMemberPassword(memberDto.getMemberPassword());
        member.setMemberName(memberDto.getMemberName());
        return member;
    }
}

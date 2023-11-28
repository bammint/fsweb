package com.example.member.entity;


import com.example.member.constant.UserRole;
import com.example.member.dto.MemberFormDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

// RDBMS(관계형데이터베이스->mysql등) Table을 객체화
// JPA로 관리되는 엔티티 객체 의미
@Entity
// 별도의 이름을 가진 데이터베이스 테이블과 매핑 (엔티티 클래스를 어떤 테이블로 생성할 것이냐)
// Entity의 클래스명과 데이터베이스의 테이블명이 다를 경우 name=""로 매핑
@Table(name="member")
@Getter
@Setter
@ToString
// NoArgs 와 AllArgs가 같이 있어야 에러가 발생하지 않는다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity{

    // primary key를 가진 변수 선언
    @Id
    // 해당 id 값을 어떻게 자동으로 생성할 지 전략 선택.
    // 각 데이터베이스에 따라 기본키 자동 생성 (mysql은 identity)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본적으로 멤버 변수명과 일치하는 데이터베이스 컬럼을 매핑
    // 선언이 꼭 필요한 것은 아님
    // @Column에서 지정한 변수명과 데이터베이스 컬럼명을 서로 다르게 주고 싶다면 (name = "")
    @Column(name = "member_id")
    private Long Id;

    @Column
    private String name;

    // 특정 열에 중복값이 입력되지 않는다?
    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private String postNm;  // 우편번호

    @Column
    private String Address; // 주소

    // @Enumberated : 자바 enum 타입을 엔티티 클래스의 속성으로 사용할 수 있다.
    // EnumType.STRING : 각 Enum 이름을 저장한다 (USER, ADMIN)
    // EnumType.ORDINAL : 각 Enum에 대응하는 순서를 컬럼에 저장한다. (0, 1, 2..)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    public static Member toMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        String addr = memberFormDto.getAddress()
                + memberFormDto.getDetailAddress()
                + memberFormDto.getExtraAddress();

        member.setName(memberFormDto.getName());
        member.setEmail(memberFormDto.getEmail());
        member.setPassword(passwordEncoder.encode(memberFormDto.getPassword()));
        member.setPhoneNumber(memberFormDto.getPhoneNumber());
        member.setPostNm(memberFormDto.getPostcode());
        member.setAddress(addr);
        member.setUserRole(UserRole.ADMIN);
        return member;
    }

}

// https://jobc.tistory.com/120
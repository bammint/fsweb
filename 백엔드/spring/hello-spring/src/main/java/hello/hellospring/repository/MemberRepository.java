package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // save: 회원이 저장소에 저장
    Optional<Member> findById(Long id); // findById: 저장소에서 id를 찾아 member 객체 반환
    Optional<Member> findByName(String name);   // findByName: 저장소에서 name을 찿아 member 객체 반환
    List<Member> findAll(); // findAll: 저장된 모든 회원의 member List 반환

    void clearStore();
}

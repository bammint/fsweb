package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;
import java.util.stream.Stream;

public class MemoryMemberRepository implements MemberRepository {

    // Map: java의 데이터 저장 방식 중 하나
    // key: Long, value: Member
    private static Map<Long, Member> store = new HashMap<>();
    // sequence: key값을 생성해줌
    private static long sequence = 0L;
    @Override
    public Member save(Member member) { // save
        member.setId(++sequence);   // sequence값 증가(key값)
        store.put(member.getId(), member);  // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { // findById
        // null일 수 있어 Optional.ofNullable() 로 감쌈
        return Optional.ofNullable(store.get(id));  // id값으로 해당 객체 store에서 꺼내서 return
    }
//    Optional<Member> memberOptional = memberService.findById(1L);
//
//    if (memberOptional.isPresent()) {
//        Member member = memberOptional.get();
//        // ID가 1인 멤버를 찾았을 때의 작업 수행
//    } else {
//        // ID가 1인 멤버를 찾지 못했을 때의 작업 수행
//    }

    @Override
    public Optional<Member> findByName(String name) {   // findByName
        // Store에서 모든 멤버값을 얻어온다
        // Collection<Member> members = store.values();
        // 모든 멤버를 스트림으로 변환하여 이름이 주어진 name과
        // 일치하는 멤버만 필터링한다
        // Stream<Member> memberStream = members.stream()
                // .filter(member -> member.getName().equals(name));
        // 필터링된 멈버 중 어떤 하나를 찾아 반환한다
        // Optional<Member> result = memberStream.findAny();
        // return result;
        return store.values().stream()  // value값들을 루프를 돌아서
                .filter(member -> member.getName().equals(name))    // param로 넘어온 name과 같은 것을 filtering
                .findAny(); // 처음 filtering 된 요소 1개를 return
    }

    @Override
    public List<Member> findAll() { // findAll
        return new ArrayList<>(store.values()); // 저장소에 있는 value들을 List로 반환
    }

    public void clearStore(){
        store.clear();
    }
}

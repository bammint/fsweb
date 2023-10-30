package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {  // 굳이 public 으로 할 필요없어서 지움
    // Test를 하기 위한 저장소
    MemberRepository repository = new MemoryMemberRepository();
    @AfterEach  // 메서드 실행이 끝날 때마다 실행됨
    public void afterEach(){
        repository.clearStore();    // 저장소 내용 다 지움
    }

    @Test
    void save() {
        Member member = new Member();   // member 객체 만듦
        member.setName("spring");
        repository.save(member);    // 저장소에 객체 member 저장

        // member의 id 값으로, 저장소에 저장된 객체 result 가져옴
        // get(): 값을 꺼내옴
        Member result = repository.findById(member.getId()).get();
        // Optional 에서 id를 꺼내려면 get()을 사용한다
        // 저장한 member와 저장소에서 가져온 result가 같은 지 검증
        //  Assertions.assertEquals(member, result);
        System.out.println("Member 정보: " + member);
        System.out.println("Result 정보: " + result);
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findByName() {
        Member member1 = new Member();   // member1 객체 만들어 저장소에 저장
        member1.setName("spring1");
        repository.save(member1);    // 저장소에 객체 member1 저장

        Member member2 = new Member();   // member2 객체 만들어 저장소에 저장
        member2.setName("spring2");
        repository.save(member2);    // 저장소에 객체 member2 저장

        // member1의 이름으로, 저장소에 저장된 객체 가져옴
        Member result = repository.findByName("spring1").get();
        System.out.println("Member 정보: " + member1);
        System.out.println("Result 정보: " + member2);
        // member1과 저장소에서 가져온 result가 같은 지 검증
        assertThat(result).isEqualTo(member1);
        // 위에서 생성한 객체와 동일한 객체인지 확인
    }

    @Test
    void findAll() {
        Member member1 = new Member();   // member1 객체 만들어 저장소에 저장
        member1.setName("spring1");
        repository.save(member1);    // 저장소에 객체 member1 저장

        Member member2 = new Member();   // member2 객체 만들어 저장소에 저장
        member2.setName("spring2");
        repository.save(member2);    // 저장소에 객체 member2 저장

        // 저장소에 저장된 객체를 List로 가져옴
        List<Member> result = repository.findAll();
        // 저장소에서 가져온 List의 size가 2와 같은 지 검증
        assertThat(result.size()).isEqualTo(2);
        for(Member member : result){
            System.out.println(member);
        }
    }
}
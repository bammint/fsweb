package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 키값 생성 전략(우리는 디비에서 생성한다)을 적는다
    // @Column(name="username")
    private String name;

    // id get,set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // name get,set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // 회원 정보를 담는 객체를 생성해준다

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

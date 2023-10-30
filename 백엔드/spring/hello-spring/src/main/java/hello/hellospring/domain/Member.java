package hello.hellospring.domain;

public class Member {
    private Long id;
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

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package study.spring.basic.domain;

import javax.persistence.*;

@Entity // jpa가 관리하는 Entity이다.
public class Member {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // DB가 Id를 자동으로 생성
    private Long id;

    @Column(name = "name")  // DB의 컬럼명 작성 (같으면 필요 X)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

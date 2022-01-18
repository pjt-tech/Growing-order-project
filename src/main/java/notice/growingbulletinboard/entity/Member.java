package notice.growingbulletinboard.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @Builder
    public Member(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}

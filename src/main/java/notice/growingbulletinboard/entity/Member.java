package notice.growingbulletinboard.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @ManyToOne
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}

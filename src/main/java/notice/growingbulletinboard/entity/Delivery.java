package notice.growingbulletinboard.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Delivery {

    @Id@GeneratedValue
    private Long id;

    private Order order;

    private Address address;

    private DeliveryStatus status;
}

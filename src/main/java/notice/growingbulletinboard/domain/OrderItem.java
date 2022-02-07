package notice.growingbulletinboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import notice.growingbulletinboard.domain.item.Item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class OrderItem {

    @Id@GeneratedValue
    private Long id;

    private Item item;

    private Order order;

    private int orderPrice;

    private int count;
}

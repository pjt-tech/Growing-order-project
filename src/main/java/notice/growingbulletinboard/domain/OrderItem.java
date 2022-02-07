package notice.growingbulletinboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import notice.growingbulletinboard.domain.item.Item;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@NoArgsConstructor
@Getter
@Entity
public class OrderItem {

    @Id@GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;

    private int count;
}

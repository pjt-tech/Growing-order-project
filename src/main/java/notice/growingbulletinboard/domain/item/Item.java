package notice.growingbulletinboard.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import notice.growingbulletinboard.domain.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    private List<Category> categories = new ArrayList<>();
}

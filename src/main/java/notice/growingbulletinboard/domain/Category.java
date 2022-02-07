package notice.growingbulletinboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import notice.growingbulletinboard.domain.item.Item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Category {

    @Id @GeneratedValue
    private Long id;

    private List<Item> items = new ArrayList<>();

    private Category parent;

    private List<Category> child = new ArrayList<>();


}

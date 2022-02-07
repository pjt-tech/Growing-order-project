package notice.growingbulletinboard.repository;

import notice.growingbulletinboard.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}

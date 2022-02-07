package notice.growingbulletinboard.repository;

import notice.growingbulletinboard.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

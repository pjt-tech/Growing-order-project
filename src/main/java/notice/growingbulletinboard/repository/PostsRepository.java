package notice.growingbulletinboard.repository;

import notice.growingbulletinboard.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}

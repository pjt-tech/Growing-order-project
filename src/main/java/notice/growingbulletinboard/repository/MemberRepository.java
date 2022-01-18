package notice.growingbulletinboard.repository;


import notice.growingbulletinboard.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}

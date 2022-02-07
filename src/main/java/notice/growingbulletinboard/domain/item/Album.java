package notice.growingbulletinboard.domain.item;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Entity;

@Getter@Setter
@Entity
public class Album extends Item{
    private String artist;
    private String etc;
}

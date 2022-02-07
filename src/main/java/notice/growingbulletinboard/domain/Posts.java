package notice.growingbulletinboard.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Posts {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdDate;

}

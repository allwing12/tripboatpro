package tripboat.tripboat1.ComunityFile;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3000)
    private String content;

    private String subject;

    @Column(length = 20)
    private String region;

    private LocalDateTime createDate;


}
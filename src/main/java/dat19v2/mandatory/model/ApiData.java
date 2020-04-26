
package dat19v2.mandatory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Data
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
 * and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * https://projectlombok.org/features/all
 */
@Data
@SuppressWarnings("unused")
@Entity
public class ApiData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apiDataId;
    private Long id;
    private String base;
    private Long cod;
    private Long dt;
    private Long visibility;
    private String name;
    private Long timezone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cloudsId")
    private Clouds clouds;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordId")
    private Coord coord;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainModelId")
    private MainModel mainModel;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sysId")
    private Sys sys;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "weatherId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Weather> weatherList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "windId")
    private Wind wind;

    @Column(name = "CreatedDate", updatable=false)
    @CreationTimestamp
    private Timestamp createdDate;

    @Column(name = "ModifiedDate")
    @UpdateTimestamp
    private Timestamp modifiedDate;
}


package dat19v2.mandatory.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Data
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
 * and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * https://projectlombok.org/features/all
 */
@Data
@SuppressWarnings("unused")
@Entity
public class Clouds
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cloudsId;
    private Long all;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "clouds")
    private ApiData apiData;

    @Column(name = "CreatedDate", updatable=false, nullable = false)
    @CreationTimestamp
    private Timestamp createdDate;

    @Column(name = "ModifiedDate")
    @UpdateTimestamp
    private Timestamp modifiedDate;

}

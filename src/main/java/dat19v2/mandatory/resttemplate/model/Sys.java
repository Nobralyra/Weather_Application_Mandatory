
package dat19v2.mandatory.resttemplate.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Data
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
 * and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * https://projectlombok.org/features/all
 */
@Data
@SuppressWarnings("unused")
@Entity
public class Sys
{
    private String country;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double message;
    private long sunrise;
    private long sunset;
    private long type;
}

package dat19v2.mandatory.resttemplate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @Data
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
 * and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * https://projectlombok.org/features/all
 */
@Data
@Entity
public class Weather
{
    private String description;
    private String icon;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String main;
}
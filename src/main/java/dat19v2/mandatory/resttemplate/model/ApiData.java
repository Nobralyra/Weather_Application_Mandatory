
package dat19v2.mandatory.resttemplate.model;

import dat19v2.mandatory.api.domain.WeatherDTO;
import dat19v2.mandatory.api.domain.WindDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String base;
    private Clouds clouds;
    private long cod;
    private Coord coord;
    private long dt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Main main;
    private String name;
    private Sys sys;
    private long timezone;
    private List<WeatherDTO> weatherDTO;
    private WindDTO windDTO;
}

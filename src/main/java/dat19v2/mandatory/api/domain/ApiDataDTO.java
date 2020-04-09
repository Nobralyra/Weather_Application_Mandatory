
package dat19v2.mandatory.api.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
 * and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * https://projectlombok.org/features/all
 */
@Data
@SuppressWarnings("unused")
@AllArgsConstructor
@NoArgsConstructor
public class ApiDataDTO
{
    private String base;
    private CloudsDTO cloudsDTO;
    private long cod;
    private CoordDTO coordDTO;
    private long dt;
    private long id;
    private MainDTO mainDTO;
    private String name;
    private SysDTO sysDTO;
    private long timezone;
    private List<WeatherDTO> weatherDTO;
    private WindDTO windDTO;

    /**
     * Overrides
     */
    @JsonProperty("api_data_url")
    private String ApiDataUrl;
}

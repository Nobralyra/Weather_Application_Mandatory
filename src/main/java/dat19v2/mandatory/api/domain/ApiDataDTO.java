
package dat19v2.mandatory.api.domain;

import java.util.ArrayList;
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
    private Long cod;
    private CoordDTO coordDTO;
    private Long dt;
    private Long id;
    private Long visibility;
    @JsonProperty("main")
    private MainDTO mainDTO;
    private String name;
    private SysDTO sysDTO;
    private Long timezone;
    private List<WeatherDTO> weatherDTOList = new ArrayList<>();
    private WindDTO windDTO;

    /**
     * Overrides
     */
    @JsonProperty("api_data_url")
    private String apiDataUrl;

    @JsonProperty("base")
    public String getBase()
    {
        return base;
    }

    public void setBase(String base)
    {
        this.base = base;
    }
    @JsonProperty("clouds")
    public CloudsDTO getCloudsDTO()
    {
        return cloudsDTO;
    }

    public void setCloudsDTO(CloudsDTO cloudsDTO)
    {
        this.cloudsDTO = cloudsDTO;
    }

    @JsonProperty("cod")
    public long getCod()
    {
        return cod;
    }

    public void setCod(long cod)
    {
        this.cod = cod;
    }

    @JsonProperty("coord")
    public CoordDTO getCoordDTO()
    {
        return coordDTO;
    }

    public void setCoordDTO(CoordDTO coordDTO)
    {
        this.coordDTO = coordDTO;
    }

    @JsonProperty("dt")
    public long getDt()
    {
        return dt;
    }

    public void setDt(long dt)
    {
        this.dt = dt;
    }

    @JsonProperty("id")
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @JsonProperty("main")
    public MainDTO getMainDTO()
    {
        return mainDTO;
    }

    @JsonProperty("main")
    public void setMainDTO(MainDTO mainDTO)
    {
        this.mainDTO = mainDTO;
    }

    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @JsonProperty("sys")
    public SysDTO getSysDTO()
    {
        return sysDTO;
    }

    public void setSysDTO(SysDTO sysDTO)
    {
        this.sysDTO = sysDTO;
    }

    @JsonProperty("timezone")
    public long getTimezone()
    {
        return timezone;
    }

    public void setTimezone(long timezone)
    {
        this.timezone = timezone;
    }

    @JsonProperty("weather")
    public List<WeatherDTO> getWeatherDTOList()
    {
        return weatherDTOList;
    }

    public void setWeatherDTOList(List<WeatherDTO> weatherDTOList)
    {
        this.weatherDTOList = weatherDTOList;
    }

    @JsonProperty("wind")
    public WindDTO getWindDTO()
    {
        return windDTO;
    }

    public void setWindDTO(WindDTO windDTO)
    {
        this.windDTO = windDTO;
    }

    public String getApiDataUrl()
    {
        return apiDataUrl;
    }
    @JsonProperty("api_data_url")
    public void setApiDataUrl(String apiDataUrl)
    {
        this.apiDataUrl = apiDataUrl;
    }

    public long getVisibility()
    {
        return visibility;
    }

    public void setVisibility(long visibility)
    {
        this.visibility = visibility;
    }
}

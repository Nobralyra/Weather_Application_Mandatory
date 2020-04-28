package dat19v2.mandatory.controllers.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import dat19v2.mandatory.api.domain.ApiDataDTO;
import dat19v2.mandatory.services.api.IAllDataOpenWeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestApiDataController.BASE_URL)
public class RestApiDataController
{
    public static final String BASE_URL = "/api/v1/weather";

    private final IAllDataOpenWeatherService iAllDataOpenWeatherService;

    public RestApiDataController(IAllDataOpenWeatherService iAllDataOpenWeatherService)
    {
        this.iAllDataOpenWeatherService = iAllDataOpenWeatherService;
    }

    @GetMapping({"/now"})
    @ResponseStatus(HttpStatus.OK)
    public ApiDataDTO getApiDataList() throws JsonProcessingException
    {
        return iAllDataOpenWeatherService.getAllOpenWeatherData();
    }
}

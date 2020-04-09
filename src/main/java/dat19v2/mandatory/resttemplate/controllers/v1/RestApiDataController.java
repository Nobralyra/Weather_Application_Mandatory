package dat19v2.mandatory.resttemplate.controllers.v1;

import dat19v2.mandatory.api.domain.ApiDataListDTO;
import dat19v2.mandatory.resttemplate.services.IApiDataService;
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

    private final IApiDataService iApiDataService;

    public RestApiDataController(IApiDataService iApiDataService)
    {
        this.iApiDataService = iApiDataService;
    }

    @GetMapping({"/now"})
    @ResponseStatus(HttpStatus.OK)
    public ApiDataListDTO getApiDataList()
    {
        return iApiDataService.getApiData();
    }


}

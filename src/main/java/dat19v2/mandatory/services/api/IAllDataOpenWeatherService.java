package dat19v2.mandatory.services.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import dat19v2.mandatory.api.domain.ApiDataDTO;

public interface IAllDataOpenWeatherService
{
    ApiDataDTO getAllOpenWeatherData() throws JsonProcessingException;
}

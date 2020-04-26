package dat19v2.mandatory.services.view;

import dat19v2.mandatory.api.domain.ApiDataDTO;
import dat19v2.mandatory.api.domain.ApiDataListDTO;
import org.springframework.stereotype.Service;

public interface IApiDataService
{
    ApiDataDTO getApiDataDTO();
}

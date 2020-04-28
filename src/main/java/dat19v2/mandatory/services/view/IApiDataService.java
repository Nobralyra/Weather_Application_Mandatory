package dat19v2.mandatory.services.view;

import dat19v2.mandatory.api.domain.ApiDataListDTO;

public interface IApiDataService
{
    ApiDataListDTO getApiDataListDTO();
    ApiDataListDTO getLast5ApiDataListDTO();
}

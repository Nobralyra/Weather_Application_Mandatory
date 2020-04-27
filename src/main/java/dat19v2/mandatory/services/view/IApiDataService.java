package dat19v2.mandatory.services.view;

import dat19v2.mandatory.api.domain.ApiDataListDTO;
import org.springframework.stereotype.Service;

public interface IApiDataService
{
    ApiDataListDTO getApiDataListDTO(Integer firstPageNumber, Integer pageSize, String sortBy);
    ApiDataListDTO getLast5ApiDataListDTO(Integer pageNumber, Integer pageSize, String sortBy);
}

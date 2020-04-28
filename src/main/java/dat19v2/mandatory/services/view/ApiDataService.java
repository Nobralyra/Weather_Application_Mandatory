package dat19v2.mandatory.services.view;

import dat19v2.mandatory.api.domain.ApiDataDTO;
import dat19v2.mandatory.api.domain.ApiDataListDTO;
import dat19v2.mandatory.api.mapper.IApiDataMapper;
import dat19v2.mandatory.repositories.IApiDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for ViewDataController
 */
@Service
@Component
public class ApiDataService implements IApiDataService
{
    @Autowired
    private final IApiDataRepository iApiDataRepository;
    int pageNumber = 0;
    int pageSize;

    @Autowired
    private final IApiDataMapper iApiDataMapper;

    public ApiDataService(IApiDataRepository iApiDataRepository, IApiDataMapper iApiDataMapper)
    {
        this.iApiDataRepository = iApiDataRepository;
        this.iApiDataMapper = iApiDataMapper;
    }

    /**
     * Get called by getApiDataListDTO() from ViewDataController, and getApiDataListDTO() wants a list of the latest data,
     * so it calls iApiDataRepository to findall with the parameter of firstPaging,
     * stream extract only the elements we asked for. map apiData to apiDataDTO
     * and return apiDataDTO, and then stores them i collection of List.
     * Then we can return a new object of ApiDataListDTO(apiDataDTOS).
     *
     * pageNumber is the page index where we want the first page
     * pageSize is the size of the page to be returned
     * Sort.by sorts all the ApiData Entity after createdDate in descending order
     * (resent/latest dates to the oldest/ealist dates)
     * https://attacomsian.com/blog/spring-data-jpa-pagination
     * https://howtodoinjava.com/spring-boot2/pagination-sorting-example/
     * @return ApiDataListDTO
     */
    @Override
    public ApiDataListDTO getApiDataListDTO()
    {
        pageSize = 1;
        Pageable firstPaging = PageRequest.of(pageNumber, pageSize, Sort.by("createdDate").descending());

        List<ApiDataDTO> apiDataDTOS = iApiDataRepository
                .findAll(firstPaging)
                .stream()
                .map(apiData -> {
                    ApiDataDTO apiDataDTO = iApiDataMapper.apiDataToApiDataDTO(apiData);
                    return apiDataDTO;
                })
                .collect(Collectors.toList());
        return new ApiDataListDTO(apiDataDTOS);
    }

    /**
     * Get called by getLast5ApiDataListDTO() from ViewDataController and works just as getApiDataListDTO(),
     * but instead of returning the latest element from the database it returns the latest 5 elements.
     * @return ApiDataListDTO
     */
    @Override
    public ApiDataListDTO getLast5ApiDataListDTO()
    {
        pageSize = 5;
        Pageable fivePaging = PageRequest.of(pageNumber, pageSize, Sort.by("createdDate").descending());

        List<ApiDataDTO> apiDataDTOS = iApiDataRepository
                .findAll(fivePaging)
                .stream()
                .map(apiData -> {
                    ApiDataDTO apiDataDTO = iApiDataMapper.apiDataToApiDataDTO(apiData);
                    return apiDataDTO;
                })
                .collect(Collectors.toList());
        return new ApiDataListDTO(apiDataDTOS);
    }
}

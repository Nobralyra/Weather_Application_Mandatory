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

@Service
@Component
public class ApiDataService implements IApiDataService
{
    private final IApiDataRepository iApiDataRepository;
    Integer pageNumber = 0;
    Integer pageSize;

    @Autowired
    private final IApiDataMapper iApiDataMapper;

    public ApiDataService(IApiDataRepository iApiDataRepository, IApiDataMapper iApiDataMapper)
    {
        this.iApiDataRepository = iApiDataRepository;
        this.iApiDataMapper = iApiDataMapper;
    }

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

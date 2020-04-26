package dat19v2.mandatory.services.view;

import dat19v2.mandatory.api.domain.ApiDataDTO;
import dat19v2.mandatory.api.domain.ApiDataListDTO;
import dat19v2.mandatory.api.mapper.IApiDataMapper;
import dat19v2.mandatory.model.Clouds;
import dat19v2.mandatory.repositories.IApiDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class ApiDataService implements IApiDataService
{
    private final IApiDataRepository iApiDataRepository;

    @Autowired
    private final IApiDataMapper iApiDataMapper;


    public ApiDataService(IApiDataRepository iApiDataRepository, IApiDataMapper iApiDataMapper)
    {
        this.iApiDataRepository = iApiDataRepository;
        this.iApiDataMapper = iApiDataMapper;
    }


    @Override
    public ApiDataDTO getApiDataDTO()
    {

    }
}

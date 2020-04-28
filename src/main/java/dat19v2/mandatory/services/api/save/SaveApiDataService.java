package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.ApiData;
import dat19v2.mandatory.repositories.IApiDataRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SaveApiDataService implements ISaveOpenWeatherService<ApiData>
{
    private final IApiDataRepository iApiDataRepository;

    public SaveApiDataService(IApiDataRepository iApiDataRepository)
    {
        this.iApiDataRepository = iApiDataRepository;
    }

    @Override
    public void save(ApiData apiData)
    {
        iApiDataRepository.save(apiData);
    }
}

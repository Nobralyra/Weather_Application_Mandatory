package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.ApiData;
import dat19v2.mandatory.repositories.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class SaveApiDataService implements ISaveOpenWeatherService<ApiData>
{
    private final IApiDataRepository iApiDataRepository;
    private final ICoordRepository iCoordRepository;
    private final IMainModelRepository iMainModelRepository;
    private final ISysRepository iSysRepository;
    private final IWeatherRepository iWeatherRepository;
    private final IWindRepository iWindRepository;

    public SaveApiDataService(IApiDataRepository iApiDataRepository, ICoordRepository iCoordRepository, IMainModelRepository iMainModelRepository, ISysRepository iSysRepository, IWeatherRepository iWeatherRepository, IWindRepository iWindRepository)
    {
        this.iApiDataRepository = iApiDataRepository;
        this.iCoordRepository = iCoordRepository;
        this.iMainModelRepository = iMainModelRepository;
        this.iSysRepository = iSysRepository;
        this.iWeatherRepository = iWeatherRepository;
        this.iWindRepository = iWindRepository;
    }

    @Override
    public void save(ApiData apiData)
    {
        System.out.println(apiData);
        iApiDataRepository.save(apiData);
    }



}

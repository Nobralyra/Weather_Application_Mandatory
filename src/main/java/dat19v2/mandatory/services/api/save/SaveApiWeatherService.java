package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.Weather;
import dat19v2.mandatory.repositories.IWeatherRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveApiWeatherService implements ISaveOpenWeatherService<Weather>
{
    public SaveApiWeatherService(IWeatherRepository iWeatherRepository)
    {
        this.iWeatherRepository = iWeatherRepository;
    }

    private final IWeatherRepository iWeatherRepository;

    @Override
    public void save(Weather weather)
    {
        System.out.println(weather);
        iWeatherRepository.save(weather);
    }
}

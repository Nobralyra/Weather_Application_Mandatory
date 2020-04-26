package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.Clouds;
import dat19v2.mandatory.repositories.ICloudsRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveApiCloudsService implements ISaveOpenWeatherService<Clouds>
{
    private final ICloudsRepository iCloudsRepository;

    public SaveApiCloudsService(ICloudsRepository iCloudsRepository)
    {
        this.iCloudsRepository = iCloudsRepository;
    }

    @Override
    public void save(Clouds clouds)
    {
        iCloudsRepository.save(clouds);
    }
}

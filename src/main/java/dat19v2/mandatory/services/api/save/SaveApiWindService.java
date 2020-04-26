package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.Wind;
import dat19v2.mandatory.repositories.IWindRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveApiWindService implements ISaveOpenWeatherService<Wind>
{
    private final IWindRepository iWindRepository;

    public SaveApiWindService(IWindRepository iWindRepository)
    {
        this.iWindRepository = iWindRepository;
    }

    @Override
    public void save(Wind wind)
    {
        iWindRepository.save(wind);
    }
}

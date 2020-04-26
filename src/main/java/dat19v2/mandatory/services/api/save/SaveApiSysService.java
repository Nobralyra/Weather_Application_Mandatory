package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.Sys;
import dat19v2.mandatory.repositories.ISysRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveApiSysService implements ISaveOpenWeatherService<Sys>
{
    private final ISysRepository iSysRepository;

    public SaveApiSysService(ISysRepository iSysRepository)
    {
        this.iSysRepository = iSysRepository;
    }

    @Override
    public void save(Sys sys)
    {
        iSysRepository.save(sys);
    }
}

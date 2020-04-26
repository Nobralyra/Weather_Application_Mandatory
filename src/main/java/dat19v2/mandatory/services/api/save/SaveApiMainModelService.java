package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.MainModel;
import dat19v2.mandatory.repositories.IMainModelRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveApiMainModelService implements ISaveOpenWeatherService<MainModel>
{
    private final IMainModelRepository iMainModelRepository;

    public SaveApiMainModelService(IMainModelRepository iMainModelRepository)
    {
        this.iMainModelRepository = iMainModelRepository;
    }

    @Override
    public void save(MainModel mainModel)
    {
        iMainModelRepository.save(mainModel);
    }
}

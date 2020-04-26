package dat19v2.mandatory.services.api.save;

import dat19v2.mandatory.model.Coord;
import dat19v2.mandatory.repositories.ICoordRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveApiCoordService implements ISaveOpenWeatherService<Coord>
{
    private final ICoordRepository iCoordRepository;

    public SaveApiCoordService(ICoordRepository iCoordRepository)
    {
        this.iCoordRepository = iCoordRepository;
    }

    @Override
    public void save(Coord coord)
    {
        iCoordRepository.save(coord);
    }
}

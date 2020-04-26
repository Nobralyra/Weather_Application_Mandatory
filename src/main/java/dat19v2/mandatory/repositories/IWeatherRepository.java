package dat19v2.mandatory.repositories;

import dat19v2.mandatory.model.ApiData;
import dat19v2.mandatory.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWeatherRepository extends JpaRepository<Weather, Long>
{
}

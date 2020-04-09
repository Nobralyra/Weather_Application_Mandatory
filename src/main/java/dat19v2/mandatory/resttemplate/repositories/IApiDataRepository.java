package dat19v2.mandatory.resttemplate.repositories;

import dat19v2.mandatory.resttemplate.model.ApiData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IApiDataRepository extends JpaRepository<ApiData, Long>
{
}


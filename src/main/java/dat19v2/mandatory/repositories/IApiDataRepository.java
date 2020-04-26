package dat19v2.mandatory.repositories;

import dat19v2.mandatory.model.ApiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApiDataRepository extends JpaRepository<ApiData, Long>
{
}


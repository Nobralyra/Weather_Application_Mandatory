package dat19v2.mandatory.repositories;

import dat19v2.mandatory.model.Clouds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICloudsRepository extends JpaRepository<Clouds, Long>
{
}

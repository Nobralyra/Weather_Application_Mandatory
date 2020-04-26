package dat19v2.mandatory.repositories;

import dat19v2.mandatory.model.Wind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWindRepository extends JpaRepository<Wind, Long>
{
}

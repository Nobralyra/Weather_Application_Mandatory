package dat19v2.mandatory.repositories;

import dat19v2.mandatory.model.Coord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoordRepository extends JpaRepository<Coord, Long>
{
}

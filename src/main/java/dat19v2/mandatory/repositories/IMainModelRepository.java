package dat19v2.mandatory.repositories;

import dat19v2.mandatory.model.MainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMainModelRepository extends JpaRepository<MainModel, Long>
{
}

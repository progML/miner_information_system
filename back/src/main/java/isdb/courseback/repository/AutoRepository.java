package isdb.courseback.repository;

import isdb.courseback.model.Auto;
import isdb.courseback.model.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutoRepository extends CrudRepository<Auto, Long> {

    Optional<Auto> findByAutoId(int equipId);

}

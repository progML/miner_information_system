package isdb.courseback.repository;

import isdb.courseback.model.Brigade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrigadeRepository extends CrudRepository<Brigade, Long> {

    Optional<Brigade> findByForemanId(int foremanId);

}

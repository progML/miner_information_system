package isdb.courseback.repository;

import isdb.courseback.model.Mining;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiningRepository extends CrudRepository<Mining, Long> {

    List<Mining> findAllByBrigadeId(int brigadeId);

}

package isdb.courseback.repository;

import isdb.courseback.model.Counter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository  extends CrudRepository<Counter, Long> {

}

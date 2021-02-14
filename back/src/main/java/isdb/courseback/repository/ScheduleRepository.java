package isdb.courseback.repository;

import isdb.courseback.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    List<Schedule> findAllByBrigadeId(int brigadeId);
}

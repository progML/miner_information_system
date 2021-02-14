package isdb.courseback.repository;

import isdb.courseback.model.MessageMiner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageMinerRepository extends CrudRepository<MessageMiner, Long> {

    List<MessageMiner> findAllByMinerId(int minerId);

}

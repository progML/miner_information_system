package isdb.courseback.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import isdb.courseback.model.Miner;

import java.util.List;
import java.util.Optional;

@Repository
public interface MinerRepository extends CrudRepository<Miner, Long> {

    Optional<Miner> findByMinerId(int id);

    @Query(nativeQuery = true, value = "Select miner_id, miner_name, age, height, weight, health_group, air_cylinder  " +
            "from miner where miner_id not in(Select miner_id from brigade_record) and miner_id not in(Select foreman_id from brigade)")
    List<Miner> showMiners();

    @Query("Select minerName from Miner where minerId = :minId")
    String findNameByMinerId(@Param("minId") int id);

}

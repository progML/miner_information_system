package isdb.courseback.repository;

import isdb.courseback.model.BrigadeRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrigadeRecordRepository extends CrudRepository<BrigadeRecord, Long> {

    Optional<BrigadeRecord> findByMinerId(int id);

    List<BrigadeRecord> findAllByBrigadeIdAndMinerIdNotIn(int id, Collection<Integer> deliveryEquipMinerId);

    List<BrigadeRecord> findAllByBrigadeId(int id);

    @Query(nativeQuery = true, value = "Select Brigade_record.miner_id, Brigade_record.brigade_id, Brigade_record.part from Brigade_record where Brigade_record.brigade_id = :brigadeId and Brigade_record.miner_id NOT IN (Select miner_id from magazine where date_work = CURRENT_DATE)")
    List<BrigadeRecord> findByBrigadeId(@Param("brigadeId") int brigadeId);

    @Query(nativeQuery = true, value = "DELETE from Brigade_record where Brigade_record.miner_id = :minerId")
    void deleteByMinerId(@Param("minerId") int id);


}

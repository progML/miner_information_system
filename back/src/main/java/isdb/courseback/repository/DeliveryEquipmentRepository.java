package isdb.courseback.repository;

import isdb.courseback.model.DeliveryEquipment;
import isdb.courseback.model.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryEquipmentRepository extends CrudRepository<DeliveryEquipment, Long> {

    @Query(value = "SELECT minerId FROM DeliveryEquipment")
    List<Integer> findAllMinerId();

    @Query("SELECT equipmentId FROM DeliveryEquipment WHERE minerId = :minId")
    Optional<Integer> findEquipIdByMinerId(int minId);

}

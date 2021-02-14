package isdb.courseback.repository;

import isdb.courseback.model.Equipment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

    Optional<Equipment> findByEquipmentId(int equipId);

}

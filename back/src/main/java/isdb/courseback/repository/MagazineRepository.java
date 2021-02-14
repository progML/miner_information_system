package isdb.courseback.repository;


import isdb.courseback.model.Magazine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long> {
     List<Magazine> findAllMagazineByMinerId(int id);
}

package isdb.courseback.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import isdb.courseback.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Long countByUsername(String username);

}

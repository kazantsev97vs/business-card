package softlab.test.task.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softlab.test.task.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

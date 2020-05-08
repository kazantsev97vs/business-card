package softlab.test.task.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softlab.test.task.entities.BusinessCard;

@Repository
public interface BusinessCardRepository extends CrudRepository<BusinessCard, Long> {
}

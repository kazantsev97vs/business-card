package softlab.test.task.services.impl;

import org.springframework.stereotype.Service;
import softlab.test.task.entities.BusinessCard;
import softlab.test.task.interfaces.impl.LoggingCRUDImpl;
import softlab.test.task.repositories.BusinessCardRepository;
import softlab.test.task.services.BusinessCardService;

/**
 * Реализация CRUD-сервиса для сущности "Визитная карточка"
 */
@Service
public class BusinessCardServiceImpl
        extends LoggingCRUDImpl<BusinessCard, Long, BusinessCardRepository> implements BusinessCardService {

    public BusinessCardServiceImpl(BusinessCardRepository repository) { super(repository); }

}
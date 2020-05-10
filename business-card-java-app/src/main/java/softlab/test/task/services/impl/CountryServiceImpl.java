package softlab.test.task.services.impl;

import org.springframework.stereotype.Service;
import softlab.test.task.entities.citizenship.Country;
import softlab.test.task.interfaces.impl.SpecificBaseEntityCRUDImpl;
import softlab.test.task.repositories.CountryRepository;
import softlab.test.task.services.CountryService;

/**
 * Реализация CRUD-сервиса для сущности "Страна"
 */
@Service
public class CountryServiceImpl
        extends SpecificBaseEntityCRUDImpl<Country, Long, CountryRepository>
        implements CountryService {

    public CountryServiceImpl(CountryRepository repository) { super(repository); }
}
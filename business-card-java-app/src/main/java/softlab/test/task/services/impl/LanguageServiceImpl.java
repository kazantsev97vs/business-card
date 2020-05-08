package softlab.test.task.services.impl;

import org.springframework.stereotype.Service;
import softlab.test.task.entities.citizenship.Language;
import softlab.test.task.interfaces.impl.SpecificBaseEntityCRUDImpl;
import softlab.test.task.repositories.LanguageRepository;
import softlab.test.task.services.LanguageService;

/**
 * Реализация CRUD-сервиса для сущности "Язык"
 */
@Service
public class LanguageServiceImpl
        extends SpecificBaseEntityCRUDImpl<Language, Long, LanguageRepository>
        implements LanguageService {

    public LanguageServiceImpl(LanguageRepository repository) { super(repository); }
}
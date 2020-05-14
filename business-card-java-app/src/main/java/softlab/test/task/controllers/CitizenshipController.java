package softlab.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import softlab.test.task.services.CountryService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/citizenship")
public class CitizenshipController {

    @Autowired
    private CountryService countryService;
    /*
        Сюда по хорошему нужно отправить сначала запрос с текущим местоположением, я делал подобное, но времени займет много
        поэтому сейчас просто выдам города России
     */

}

package softlab.test.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softlab.test.task.entities.experience.ProfessionalArea;
import softlab.test.task.models.ApiErrorResponse;
import softlab.test.task.models.ApiResponse;
import softlab.test.task.services.ProfessionalAreaService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/business-card")
public class BusinessCardController {

    @Autowired
    private ProfessionalAreaService professionalAreaService;

    @GetMapping
    public HttpEntity<ApiResponse<ProfessionalArea>> get(@RequestParam(value = "professionalAreaName", defaultValue = "World") String professionalAreaName) {

        ProfessionalArea professionalArea = professionalAreaService.getByName(professionalAreaName);
        ApiResponse<ProfessionalArea> response = new ApiResponse<>(professionalArea);

        if(null == professionalArea) response = new ApiErrorResponse<>(null, "No professional area with the name " + professionalAreaName);

        response.add(linkTo(methodOn(BusinessCardController.class).get(professionalAreaName)).withSelfRel());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package softlab.test.task.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import softlab.test.task.entities.experience.ProfessionalArea;
import softlab.test.task.util.ProfessionalAreas;

import java.io.IOException;
import java.util.List;

@SpringBootTest
public class ProfessionalAreaServiceCRUDTest {

    @Autowired
    private ProfessionalAreaService professionalAreaService;

    @Test
    public void shouldProfessionalAreasExistsAfterSaving() {

        try {
            List<ProfessionalArea> professionalAreas = ProfessionalAreas.fillProfessionalAreas();
            professionalAreas = professionalAreaService.saveAll(professionalAreas);

            assert professionalAreas != null;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
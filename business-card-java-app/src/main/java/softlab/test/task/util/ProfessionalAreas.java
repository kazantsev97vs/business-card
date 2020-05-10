package softlab.test.task.util;

import softlab.test.task.entities.experience.Position;
import softlab.test.task.entities.experience.ProfessionalArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfessionalAreas {

    public static List<ProfessionalArea> fillProfessionalAreas() throws IOException {

        Map<String, String> professionsNameLinks = HHruParser.getProfessions();

        List<ProfessionalArea> professionalAreas = new ArrayList<>();

        for (Map.Entry<String, String> professionNameAndLink : professionsNameLinks.entrySet()) {


            String professionalAreaName = professionNameAndLink.getKey();
            String professionalAreaHref = professionNameAndLink.getValue();

            List<String> positionsNames = HHruParser.getProfessionPositions(professionalAreaHref);

            List<Position> positions = new ArrayList<>();

            for (String name : positionsNames) positions.add(new Position(name));

            ProfessionalArea professionalArea = new ProfessionalArea(professionalAreaName, positions);

            professionalArea.setName(professionalAreaName);
            professionalArea.setPositions(positions);

            professionalAreas.add(professionalArea);
        }

        return professionalAreas;
    }
}
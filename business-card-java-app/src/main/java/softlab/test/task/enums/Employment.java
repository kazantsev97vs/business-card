package softlab.test.task.enums;

/**
 * Занятость
 */
public enum Employment {

    FULL_EMPLOYMENT ("Полная занятость"),
    PARTIAL_EMPLOYMENT ("Частичная занятость"),
    DESIGN_WORK ("Проектная работа"),
    VOLUNTEERISM ("Волонтерство"),
    INTERNSHIP ("Стажировка");

    private String value;

    Employment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
package softlab.test.task.enums;

/**
 * Переезд
 */
public enum Moving {

    NOT_POSSIBLE ("Невозможен"),
    POSSIBLE ("Возможен"),
    DESIRABLE ("Желателен");

    private String value;

    Moving(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
package softlab.test.task.enums;

/**
 * График работы
 */
public enum WorkSchedule {

    FULL_DAY ("Полный день"),
    SHIFT_SCHEDULE ("Сменный график"),
    FLEXIBLE_SCHEDULE ("Гибкий график"),
    REMOTE_WORK ("Удаленная работа"),
    SHIFT_METHOD ("Вахтовый метод");

    private String value;

    WorkSchedule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
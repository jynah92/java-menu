package menu.model.enums;

public enum Day {
    MONDAY(0, "월요일"),
    TUESDAY(1, "화요일"),
    WEDNSDAY(2, "수요일"),
    THURSDAY(3, "목요일"),
    FRIDAY(4, "금요일");

    private static final String DAY_NOT_FOUND_BY_INDEX_ERROR = "[ERROR] 입력된 변호에 해당하는 요일이 존재하지 않습니다.";

    private final int index;
    private final String name;

    Day(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static Day getDayByIndex(int index) {
        for (Day day : values()) {
            if (day.getIndex() == index) {
                return day;
            }
        }

        throw new IllegalArgumentException(DAY_NOT_FOUND_BY_INDEX_ERROR);
    }

    public static int getDaySize() {
        return values().length;
    }
}

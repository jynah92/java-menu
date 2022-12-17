package menu.model.enums;

public enum Category {
    KOREAN("한식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    WESTERN("양식");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

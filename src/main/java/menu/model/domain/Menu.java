package menu.model.domain;

import menu.model.enums.Category;

public class Menu {
    private final Category category;
    private final String name;

    public Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}

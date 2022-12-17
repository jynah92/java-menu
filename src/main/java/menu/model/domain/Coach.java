package menu.model.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> menusCantEat;

    public Coach (String name, List<Menu> menusCantEat) {
        this.name = name;
        this.menusCantEat = menusCantEat;
    }

    public String getName() {
        return name;
    }
}

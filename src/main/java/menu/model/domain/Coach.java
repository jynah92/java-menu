package menu.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<Menu> menusCantEat;
    private final List<Menu> menusRecommended;

    public Coach (String name, List<Menu> menusCantEat) {
        this.name = name;
        this.menusCantEat = menusCantEat;
        this.menusRecommended = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}

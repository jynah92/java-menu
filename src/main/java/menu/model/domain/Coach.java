package menu.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private static final String PRINT_START = "[ ";
    private static final String PRINT_REDUX = " | ";
    private static final String PRINT_END = " ]";

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

    public boolean addRecommendedMenu(Menu menu) {
        if (menusCantEat.contains(menu) || menusRecommended.contains(menu)) {
            return false;
        }

        menusRecommended.add(menu);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(PRINT_START + this.name);

        for (Menu recommendedMenu : menusRecommended) {
            sb.append(PRINT_REDUX).append(recommendedMenu.getName());
        }

        sb.append(PRINT_END);

        return sb.toString();
    }
}

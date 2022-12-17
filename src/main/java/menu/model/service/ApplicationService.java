package menu.model.service;

import menu.model.domain.*;
import menu.model.enums.Category;
import menu.model.enums.Day;

import java.util.List;

public class ApplicationService {
    private static final ApplicationService INSTANCE = new ApplicationService();

    private final CoachRepository coachRepository;
    private final MenuRepository menuRepository;

    private ApplicationService() {
        coachRepository = CoachRepository.getInstance();
        menuRepository = MenuRepository.getInstance();
    }

    public static ApplicationService getInstance() {
        return INSTANCE;
    }

    public void addCoachWithMenusCantEat(List<String> menuNamesCantEat, String coachName) {
        while (true) {
            try {
                List<Menu> menusCantEat =
                        menuRepository.findAllMenusByNames(menuNamesCantEat);

                coachRepository.addCoach(coachName, menusCantEat);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Categories getNewCategories() {
        return new Categories();
    }

    public void addRecommendMenusInCoachesByCategories(Categories categories, List<String> coachNames) {
        for (Day day : Day.values()) {
            addRecommendMenusInCoachesByCategory(coachNames, categories.getCategoryByDay(day));
        }
    }

    private void addRecommendMenusInCoachesByCategory(List<String> coachNames, Category category) {
        for (String coachName : coachNames) {
            addRecommendMenusInCoachByCategory(category, coachName);
        }
    }

    private void addRecommendMenusInCoachByCategory(Category category, String coachName) {
        while (true) {
            Menu menu = menuRepository.findRandomMenuByCategory(category);

            if (coachRepository.addRecommendedMenuToCoachByName(menu, coachName)) {
                break;
            }
        }
    }

    public String getCoachesLineForPrint() {
        StringBuilder sb = new StringBuilder();

        for (Coach coach : coachRepository.findAllCoaches()) {
            sb.append(coach.toString()).append("\n");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}

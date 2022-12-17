package menu;

import menu.model.domain.*;
import menu.model.enums.Category;
import menu.model.enums.Day;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printStartMessage();

        List<String> coachNames = InputView.inputCoachNames();
        addCoachesWithMenusCantEat(coachNames);

        Categories categories = new Categories();
        addRecommendMenusInCoachesByCategories(categories, coachNames);
    }

    private static void addCoachesWithMenusCantEat(List<String> coachNames) {
        for (String coachName : coachNames) {
            addCoachWithMenusCantEat(coachName);
        }
    }

    private static void addCoachWithMenusCantEat(String coachName) {
        while (true) {
            try {
                List<Menu> menusCantEat =
                        MenuRepository.findAllMenusByNames(InputView.inputMenuNamesCantEat(coachName));

                CoachRepository.addCoach(coachName, menusCantEat);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addRecommendMenusInCoachesByCategories(Categories categories, List<String> coachNames) {
        for (Day day : Day.values()) {
            addRecommendMenusInCoachesByCategory(coachNames, categories.getCategoryByDay(day));
        }
    }

    private static void addRecommendMenusInCoachesByCategory(List<String> coachNames, Category category) {
        for (String coachName : coachNames) {
            addRecommendMenusInCoachByCategory(category, coachName);
        }
    }

    private static void addRecommendMenusInCoachByCategory(Category category, String coachName) {
        while (true) {
            Menu menu = MenuRepository.findRandomMenuByCategory(category);

            if (CoachRepository.addRecommendedMenuToCoachByName(menu, coachName)) {
                break;
            }
        }
    }
}

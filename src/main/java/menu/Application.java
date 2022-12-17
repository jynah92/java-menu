package menu;

import menu.model.domain.*;
import menu.model.service.ApplicationService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Application {
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final OutputView OUTPUT_VIEW = OutputView.getInstance();
    private static final ApplicationService APP_SERVICE = ApplicationService.getInstance();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OUTPUT_VIEW.printStartMessage();

        List<String> coachNames = INPUT_VIEW.inputCoachNames();

        for (String coachName : coachNames) {
            List<String> menuNamesCantEat = INPUT_VIEW.inputMenuNamesCantEat(coachName);
            APP_SERVICE.addCoachWithMenusCantEat(menuNamesCantEat, coachName);
        }

        Categories categories = APP_SERVICE.getNewCategories();
        APP_SERVICE.addRecommendMenusInCoachesByCategories(categories, coachNames);

        OUTPUT_VIEW.printResult(categories.toString(), APP_SERVICE.getCoachesLineForPrint());
    }
}

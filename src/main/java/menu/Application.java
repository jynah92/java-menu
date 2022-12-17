package menu;

import menu.model.domain.CoachRepository;
import menu.model.domain.Menu;
import menu.model.domain.MenuRepository;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printStartMessage();
        List<String> coachNames = InputView.inputCoachNames();

        for (String coachName : coachNames) {
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
    }
}

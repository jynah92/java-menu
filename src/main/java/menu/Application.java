package menu;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printStartMessage();
        List<String> coachNames = InputView.inputCoachNames();
    }
}

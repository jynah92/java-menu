package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.ParsingUtil;
import menu.util.exception.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    private static final String INPUT_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_MENU_CANT_EAT_MESSAGE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요. (, 로 구분)\n";
    private static final int COACH_NAMES_MIN_SIZE = 2;
    private static final int COACH_NAMES_MAX_SIZE = 5;
    private static final int COACH_NAME_MIN_LENGTH = 2;
    private static final int COACH_NAME_MAX_LENGTH = 4;
    private static final int MENUS_CANT_EAT_MIN_SIZE = 0;
    private static final int MENUS_CANT_EAT_MAX_SIZE = 2;
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public List<String> inputCoachNames() {
        while (true) {
            try {
                System.out.println(INPUT_COACH_NAMES_MESSAGE);
                List<String> coachNames = ParsingUtil.stringToListByComma(Console.readLine());
                checkCoachNamesSize(coachNames.size());
                checkEachCoachNamesLength(coachNames);
                checkCoachNamesDistinct(coachNames);
                return coachNames;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkCoachNamesSize(int size) {
        if (size < COACH_NAMES_MIN_SIZE || size > COACH_NAMES_MAX_SIZE) {
            throw new InputCoachNamesSizeException();
        }
    }

    private void checkEachCoachNamesLength(List<String> coachNames) {
        for (String coachName : coachNames) {
            if (coachName.length() < COACH_NAME_MIN_LENGTH || coachName.length() > COACH_NAME_MAX_LENGTH) {
                throw new InputCoachNameLengthException();
            }
        }
    }

    private void checkCoachNamesDistinct(List<String> coachNames) {
        Set<String> checkDistinct = new HashSet<>(coachNames);

        if (coachNames.size() != checkDistinct.size()) {
            throw new InputCoachNameNotDistinctException();
        }
    }

    public List<String> inputMenuNamesCantEat(String coachName) {
        while (true) {
            try {
                System.out.printf(INPUT_MENU_CANT_EAT_MESSAGE, coachName);
                List<String> menuNamesCantEat = ParsingUtil.stringToListByComma(Console.readLine());
                checkMenusCantEatSize(menuNamesCantEat.size());
                checkMenusCantEatDistinct(menuNamesCantEat);
                return menuNamesCantEat;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void checkMenusCantEatSize(int size) {
        if (size < MENUS_CANT_EAT_MIN_SIZE || size > MENUS_CANT_EAT_MAX_SIZE) {
            throw new InputMenusCantEatSizeException();
        }
    }

    private void checkMenusCantEatDistinct(List<String> menuNamesCantEat) {
        Set<String> checkDistinct = new HashSet<>(menuNamesCantEat);

        if (menuNamesCantEat.size() != checkDistinct.size()) {
            throw new InputMenuNotDistinctException();
        }
    }
}

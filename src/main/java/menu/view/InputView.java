package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.util.ParsingUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    private static final String COACH_NAMES_SIZE_ERROR = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능합니다.";
    private static final String COACH_NAME_LENGTH_ERROR = "[ERROR] 코치의 이름은 최소 두 글자, 최대 네 글자까지 입력 가능합니다.";
    private static final String COACH_NAME_NOT_DISTINCT_ERROR = "[ERROR] 중복된 코치의 이름이 존재합니다.";
    private static final String MENUS_CANT_EAT_SIZE_ERROR = "[ERROR] 각 코치가 먹을 수 없는 메뉴의 수는 최소 0개, 최대 2개까지 입력 가능합니다.";

    private static final int COACH_NAMES_MIN_SIZE = 2;
    private static final int COACH_NAMES_MAX_SIZE = 5;
    private static final int COACH_NAME_MIN_LENGTH = 2;
    private static final int COACH_NAME_MAX_LENGTH = 4;
    private static final int MENUS_CANT_EAT_MIN_SIZE = 0;
    private static final int MENUS_CANT_EAT_MAX_SIZE = 2;

    private static final String INPUT_COACH_NAMES_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_MENU_CANT_EAT_MESSAGE = "\n%s(이)가 못 먹는 메뉴를 입력해 주세요. (, 로 구분)\n";

    public static List<String> inputCoachNames() {
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

    private static void checkCoachNamesSize(int size) {
        if (size < COACH_NAMES_MIN_SIZE || size > COACH_NAMES_MAX_SIZE) {
            throw new IllegalArgumentException(COACH_NAMES_SIZE_ERROR);
        }
    }

    private static void checkEachCoachNamesLength(List<String> coachNames) {
        for (String coachName : coachNames) {
            if (coachName.length() < COACH_NAME_MIN_LENGTH || coachName.length() > COACH_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR);
            }
        }
    }

    private static void checkCoachNamesDistinct(List<String> coachNames) {
        Set<String> checkDistinct = new HashSet<>(coachNames);

        if (coachNames.size() != checkDistinct.size()) {
            throw new IllegalArgumentException(COACH_NAME_NOT_DISTINCT_ERROR);
        }
    }

    public static List<String> inputMenuNamesCantEat(String coachName) {
        while (true) {
            try {
                System.out.printf(INPUT_MENU_CANT_EAT_MESSAGE, coachName);
                List<String> menuNamesCantEat = ParsingUtil.stringToListByComma(Console.readLine());
                checkMenusCantEatSize(menuNamesCantEat.size());
                return menuNamesCantEat;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkMenusCantEatSize(int size) {
        if (size < MENUS_CANT_EAT_MIN_SIZE || size > MENUS_CANT_EAT_MAX_SIZE) {
            throw new IllegalArgumentException(MENUS_CANT_EAT_SIZE_ERROR);
        }

    }
}

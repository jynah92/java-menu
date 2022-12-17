package menu.util.exception;

public class InputMenuNotDistinctException extends InputException {
    private static final String INPUT_MENU_NOT_DISTINCT_ERROR = "[ERROR] 중복된 메뉴의 이름이 존재합니다.";

    public InputMenuNotDistinctException() {
        super(INPUT_MENU_NOT_DISTINCT_ERROR);
    }
}

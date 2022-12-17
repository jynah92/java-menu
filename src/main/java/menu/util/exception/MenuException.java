package menu.util.exception;

public class MenuException extends RuntimeException {
    private static final String MENU_ERROR = "[ERROR] 메뉴와 관련된 오류가 발생하였습니다.";

    public MenuException() {
        super(MENU_ERROR);
    }

    public MenuException(String message) {
        super(message);
    }
}

package menu.util.exception;

public class MenuNotFoundByNameException extends MenuException {
    private static final String MENU_NOT_FOUND_BY_NAME_ERROR = "[ERROR] 입력된 이름에 해당하는 메뉴가 존재하지 않습니다.";

    public MenuNotFoundByNameException() {
        super(MENU_NOT_FOUND_BY_NAME_ERROR);
    }
}

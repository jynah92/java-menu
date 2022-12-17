package menu.util.exception;

public class MenuNotFoundByCategoryException extends MenuException {
    private static final String MENU_NOT_FOUND_BY_CATEGORY_ERROR = "[ERROR] 입력된 카테고리에 해당하는 메뉴가 존재하지 않습니다.";

    public MenuNotFoundByCategoryException() {
        super(MENU_NOT_FOUND_BY_CATEGORY_ERROR);
    }
}

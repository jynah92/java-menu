package menu.util.exception;

public class InputMenusCantEatSizeException extends InputException {
    private static final String INPUT_MENUS_CANT_EAT_SIZE_ERROR = "[ERROR] 각 코치가 먹을 수 없는 메뉴의 수는 최소 0개, 최대 2개까지 입력 가능합니다.";

    public InputMenusCantEatSizeException() {
        super(INPUT_MENUS_CANT_EAT_SIZE_ERROR);
    }
}

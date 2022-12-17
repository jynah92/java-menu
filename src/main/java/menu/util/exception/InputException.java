package menu.util.exception;

public class InputException extends IllegalArgumentException {
    private static final String ILLEGAL_INPUT_ERROR = "[ERROR] 잘못된 값을 입력하였습니다.";

    public InputException() {
        super(ILLEGAL_INPUT_ERROR);
    }

    public InputException(String message) {
        super(message);
    }
}

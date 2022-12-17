package menu.util.exception;

public class DayException extends RuntimeException {
    private static final String DAY_ERROR = "[ERROR] 요일과 관련된 오류가 발생하였습니다.";

    public DayException() {
        super(DAY_ERROR);
    }

    public DayException(String message) {
        super(message);
    }
}

package menu.util.exception;

public class CoachException extends RuntimeException {
    private static final String COACH_ERROR = "[ERROR] 코치와 관련된 오류가 발생하였습니다.";

    public CoachException() {
        super(COACH_ERROR);
    }

    public CoachException(String message) {
        super(message);
    }
}

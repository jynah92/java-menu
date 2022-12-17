package menu.util.exception;

public class InputCoachNameNotDistinctException extends InputException {
    private static final String INPUT_COACH_NAME_NOT_DISTINCT_ERROR = "[ERROR] 중복된 코치의 이름이 존재합니다.";

    public InputCoachNameNotDistinctException() {
        super(INPUT_COACH_NAME_NOT_DISTINCT_ERROR);
    }
}

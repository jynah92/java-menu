package menu.util.exception;

public class InputCoachNamesSizeException extends InputException {
    private static final String INPUT_COACH_NAMES_SIZE_ERROR = "[ERROR] 코치는 최소 2명, 최대 5명까지 입력 가능합니다.";

    public InputCoachNamesSizeException() {
        super(INPUT_COACH_NAMES_SIZE_ERROR);
    }
}

package menu.util.exception;

public class InputCoachNameLengthException extends InputException {
    private static final String INPUT_COACH_NAME_LENGTH_ERROR = "[ERROR] 코치의 이름은 최소 두 글자, 최대 네 글자까지 입력 가능합니다.";

    public InputCoachNameLengthException() {
        super(INPUT_COACH_NAME_LENGTH_ERROR);
    }
}

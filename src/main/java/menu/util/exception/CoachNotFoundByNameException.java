package menu.util.exception;

public class CoachNotFoundByNameException extends CoachException {
    private static final String COACH_NOT_FOUND_BY_NAME_ERROR = "[ERROR] 입력된 이름에 해당하는 코치가 존재하지 않습니다.";

    public CoachNotFoundByNameException() {
        super(COACH_NOT_FOUND_BY_NAME_ERROR);
    }
}

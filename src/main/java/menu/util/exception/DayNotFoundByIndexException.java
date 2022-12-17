package menu.util.exception;

public class DayNotFoundByIndexException extends DayException {
    private static final String DAY_NOT_FOUND_BY_INDEX_ERROR = "[ERROR] 입력된 변호에 해당하는 요일이 존재하지 않습니다.";

    public DayNotFoundByIndexException() {
        super(DAY_NOT_FOUND_BY_INDEX_ERROR);
    }
}

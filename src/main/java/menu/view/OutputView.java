package menu.view;

public class OutputView {
    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.\n";
    private static final String RESULT_MESSAGE = "\n메뉴 추천 결과입니다.";
    private static final String END_MESSAGE = "\n추천을 완료했습니다.";
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(String categoriesLine, String coachesLine) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(categoriesLine);
        System.out.println(coachesLine);
        System.out.println(END_MESSAGE);
    }
}

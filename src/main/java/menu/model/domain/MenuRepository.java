package menu.model.domain;

import menu.model.enums.Category;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private static final String MENU_NOT_FOUND_BY_NAME_ERROR = "[ERROR] 입력된 이름에 해당하는 메뉴가 존재하지 않습니다.";
    private static final List<Menu> MENUS = new ArrayList<>();

    static {
        // 일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
        MENUS.add(new Menu(Category.JAPANESE, "규동"));
        MENUS.add(new Menu(Category.JAPANESE, "우동"));
        MENUS.add(new Menu(Category.JAPANESE, "미소시루"));
        MENUS.add(new Menu(Category.JAPANESE, "스시"));
        MENUS.add(new Menu(Category.JAPANESE, "가츠동"));
        MENUS.add(new Menu(Category.JAPANESE, "오니기리"));
        MENUS.add(new Menu(Category.JAPANESE, "하이라이스"));
        MENUS.add(new Menu(Category.JAPANESE, "라멘"));
        MENUS.add(new Menu(Category.JAPANESE, "오코노미야끼"));

        // 한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
        MENUS.add(new Menu(Category.KOREAN, "김밥"));
        MENUS.add(new Menu(Category.KOREAN, "김치찌개"));
        MENUS.add(new Menu(Category.KOREAN, "쌈밥"));
        MENUS.add(new Menu(Category.KOREAN, "된장찌개"));
        MENUS.add(new Menu(Category.KOREAN, "비빔밥"));
        MENUS.add(new Menu(Category.KOREAN, "칼국수"));
        MENUS.add(new Menu(Category.KOREAN, "불고기"));
        MENUS.add(new Menu(Category.KOREAN, "떡볶이"));
        MENUS.add(new Menu(Category.KOREAN, "제육볶음"));

        // 중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
        MENUS.add(new Menu(Category.CHINESE, "깐풍기"));
        MENUS.add(new Menu(Category.CHINESE, "볶음면"));
        MENUS.add(new Menu(Category.CHINESE, "동파육"));
        MENUS.add(new Menu(Category.CHINESE, "짜장면"));
        MENUS.add(new Menu(Category.CHINESE, "짬뽕"));
        MENUS.add(new Menu(Category.CHINESE, "마파두부"));
        MENUS.add(new Menu(Category.CHINESE, "탕수육"));
        MENUS.add(new Menu(Category.CHINESE, "토마토 달걀볶음"));
        MENUS.add(new Menu(Category.CHINESE, "고추잡채"));

        // 아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
        MENUS.add(new Menu(Category.ASIAN, "팟타이"));
        MENUS.add(new Menu(Category.ASIAN, "카오 팟"));
        MENUS.add(new Menu(Category.ASIAN, "나시고렝"));
        MENUS.add(new Menu(Category.ASIAN, "파인애플 볶음밥"));
        MENUS.add(new Menu(Category.ASIAN, "쌀국수"));
        MENUS.add(new Menu(Category.ASIAN, "똠얌꿍"));
        MENUS.add(new Menu(Category.ASIAN, "반미"));
        MENUS.add(new Menu(Category.ASIAN, "월남쌈"));
        MENUS.add(new Menu(Category.ASIAN, "분짜"));

        // 양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
        MENUS.add(new Menu(Category.WESTERN, "라자냐"));
        MENUS.add(new Menu(Category.WESTERN, "그라탱"));
        MENUS.add(new Menu(Category.WESTERN, "뇨끼"));
        MENUS.add(new Menu(Category.WESTERN, "끼슈"));
        MENUS.add(new Menu(Category.WESTERN, "프렌치 토스트"));
        MENUS.add(new Menu(Category.WESTERN, "바게트"));
        MENUS.add(new Menu(Category.WESTERN, "스파게티"));
        MENUS.add(new Menu(Category.WESTERN, "피자"));
        MENUS.add(new Menu(Category.WESTERN, "파니니"));
    }

    public static List<Menu> findAllMenusByNames(List<String> names) {
        List<Menu> menus = new ArrayList<>();

        if (names.size() == 0) {
            return menus;
        }

        for (String name : names) {
            menus.add(findMenuByName(name));
        }

        return menus;
    }

    public static Menu findMenuByName(String name) {
        for (Menu menu : MENUS) {
            if (menu.getName().equals(name)) {
                return menu;
            }
        }

        throw new IllegalArgumentException(MENU_NOT_FOUND_BY_NAME_ERROR);
    }
}

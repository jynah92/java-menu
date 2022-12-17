package menu.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.enums.Category;
import menu.model.enums.Day;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    // 월, 화, 수, 목, 금 -> 총 다섯 개
    private static final int CATEGORIES_MAX_SIZE = Day.getDaySize();
    private static final String PRINT_START = "[ ";
    private static final String PRINT_REDUX = " | ";
    private static final String PRINT_END = " ]";
    private static final String DAY_LINE_TITLE = "구분";
    private static final String CATEGORY_LINE_TITLE = "카테고리";

    private final List<Category> categories;

    public Categories() {
        categories = new ArrayList<>();
        List<Category> categoryValues = List.of(Category.values());

        while (categories.size() < CATEGORIES_MAX_SIZE) {
            Category category = categoryValues.get(Randoms.pickNumberInRange(1, categoryValues.size()) - 1);

            if (countCategory(category) < 2) {
                categories.add(category);
            }
        }
    }

    private int countCategory(Category category) {
        return (int) categories.stream()
                .filter(e -> e == category)
                .count();
    }

    public Category getCategoryByDay(Day day) {
        return categories.get(day.getIndex());
    }

    @Override
    public String toString() {
        return getDayLine() + "\n" + getCategoryLine();
    }

    private String getDayLine() {
        StringBuilder sb = new StringBuilder(PRINT_START + DAY_LINE_TITLE);

        for (int index = 0; index < CATEGORIES_MAX_SIZE; index++) {
            sb.append(PRINT_REDUX).append(Day.getDayByIndex(index).getName());
        }

        sb.append(PRINT_END);

        return sb.toString();
    }

    private String getCategoryLine() {
        StringBuilder sb = new StringBuilder(PRINT_START + CATEGORY_LINE_TITLE);

        for (Category category : categories) {
            sb.append(PRINT_REDUX).append(category.getName());
        }

        sb.append(PRINT_END);

        return sb.toString();
    }
}

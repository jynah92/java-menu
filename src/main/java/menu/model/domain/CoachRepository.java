package menu.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    public static final String HAS_NO_COACH_NAME_ERROR = "[ERROR] 입력된 이름에 해당하는 코치가 존재하지 않습니다.";
    private static final List<Coach> COACHES = new ArrayList<>();

    public static List<Coach> findAllCoaches() {
        return Collections.unmodifiableList(COACHES);
    }

    public static void addCoach(String coachName, List<Menu> menusCantEat) {
        COACHES.add(new Coach(coachName, menusCantEat));
    }

    public static boolean addRecommendedMenuToCoachByName(Menu menu, String coachName) {
        Coach coach = getCoachByName(coachName);
        return coach.addRecommendedMenu(menu);
    }

    private static Coach getCoachByName(String coachName) {
        for (Coach coach : COACHES) {
            if (coach.getName().equals(coachName)) {
                return coach;
            }
        }

        throw new IllegalArgumentException(HAS_NO_COACH_NAME_ERROR);
    }
}

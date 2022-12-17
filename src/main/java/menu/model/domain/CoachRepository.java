package menu.model.domain;

import menu.util.exception.CoachNotFoundByNameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoachRepository {
    private static final List<Coach> COACHES = new ArrayList<>();
    private static final CoachRepository INSTANCE = new CoachRepository();

    private CoachRepository() {
    }

    public static CoachRepository getInstance() {
        return INSTANCE;
    }

    public List<Coach> findAllCoaches() {
        return Collections.unmodifiableList(COACHES);
    }

    public void addCoach(String coachName, List<Menu> menusCantEat) {
        COACHES.add(new Coach(coachName, menusCantEat));
    }

    public boolean addRecommendedMenuToCoachByName(Menu menu, String coachName) {
        Coach coach = getCoachByName(coachName);
        return coach.addRecommendedMenu(menu);
    }

    private Coach getCoachByName(String coachName) {
        for (Coach coach : COACHES) {
            if (coach.getName().equals(coachName)) {
                return coach;
            }
        }

        throw new CoachNotFoundByNameException();
    }
}

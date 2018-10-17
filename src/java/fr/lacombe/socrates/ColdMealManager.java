package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class ColdMealManager {

    public static final LocalDateTime KITCHEN_CLOSE_START_TIME = LocalDateTime.of(2018, 10, 18, 21, 0);
    public static final LocalDateTime KITCHEN_CLOSE_END_TIME = LocalDateTime.of(2018, 10, 19, 0, 1);

    public static ColdMealManager of() {
        return new ColdMealManager();
    }

    public int getNumberOfColdMeals() {
        return 0;
    }
}

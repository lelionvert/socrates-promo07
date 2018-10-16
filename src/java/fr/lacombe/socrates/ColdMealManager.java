package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class ColdMealManager {

    private static final LocalDateTime START_COLD_MEAL_TIME = LocalDateTime.of(2018, 10, 18, 21, 0);
    private static final LocalDateTime END_COLD_MEAL_TIME = LocalDateTime.of(2018, 10, 19, 0, 1);

    public static int getColdMeals(CheckIn checkIn) {
        if (null == checkIn.getTime()) {
            return 0;
        }
        if (checkIn.getTime().isBefore(END_COLD_MEAL_TIME)
                && checkIn.getTime().isAfter(START_COLD_MEAL_TIME)) {
            return 1;
        }

        return 0;
    }
}

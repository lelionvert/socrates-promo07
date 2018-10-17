package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class ColdMealManager {

    private static final LocalDateTime KITCHEN_CLOSE_START_TIME = LocalDateTime.of(2018, 10, 18, 21, 0);
    private static final LocalDateTime KITCHEN_CLOSE_END_TIME = LocalDateTime.of(2018, 10, 19, 0, 1);

    public static int getColdMeals(CheckIn checkIn) {
        if (null == checkIn) {
            return 0;
        }

        return checkIn.isInKitchenClosePeriod(KITCHEN_CLOSE_START_TIME, KITCHEN_CLOSE_END_TIME)
                ? 1
                : 0;
    }

}

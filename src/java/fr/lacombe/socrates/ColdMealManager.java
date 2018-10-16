package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class ColdMealManager {

    public static int getColdMeals(LocalDateTime checkinDate) {
        LocalDateTime startTime = LocalDateTime.of(2018, 10, 18, 21, 0);
        LocalDateTime endTime = LocalDateTime.of(2018, 10, 19, 0, 1);

        if (null == checkinDate) {
            return 0;
        }
        if (checkinDate.isBefore(endTime) && checkinDate.isAfter(startTime)) {
            return 1;
        }

        return 0;
    }
}

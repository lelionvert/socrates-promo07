package fr.lacombe.socrates;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ColdMealManager {

    public static int getColdMeals(LocalDateTime checkinDate) {
        if (null == checkinDate)
            return 0;
        if (checkinDate.getDayOfWeek().equals(DayOfWeek.FRIDAY) && checkinDate.getMinute() > 0) {
            return 0;
        }
        if (checkinDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            return 1;
        }
        if (checkinDate.getHour() < 21) {
            return 0;
        }
        if (checkinDate.getHour() > 21) {
            return 1;
        }
        if (checkinDate.getMinute() > 0) {
            return 1;
        }
        return 0;
    }
}

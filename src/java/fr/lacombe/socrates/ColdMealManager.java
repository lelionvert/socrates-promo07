package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class ColdMealManager {

    public static final LocalDateTime KITCHEN_CLOSE_START_TIME = LocalDateTime.of(2018, 10, 18, 21, 0);
    public static final LocalDateTime KITCHEN_CLOSE_END_TIME = LocalDateTime.of(2018, 10, 19, 0, 1);

    private final Participant participant;

    private ColdMealManager() {
        participant = null;
    }

    private ColdMealManager(Participant participant) {
        this.participant = participant;
    }

    public static ColdMealManager of() {
        return new ColdMealManager();
    }

    public static ColdMealManager of(Participant participant) {
        return new ColdMealManager(participant);
    }

    public int getNumberOfColdMeals() {
        return null != participant && participant.hasColdMeal() ? 1 : 0;
    }
}

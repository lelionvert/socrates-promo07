package fr.lacombe.socrates;

import static fr.lacombe.socrates.ColdMealManager.KITCHEN_CLOSE_END_TIME;
import static fr.lacombe.socrates.ColdMealManager.KITCHEN_CLOSE_START_TIME;

public class Participant {

    private final String name;
    private final CheckIn checkIn;

    public Participant(String name, CheckIn checkIn) {
        this.name = name;
        this.checkIn = checkIn;
    }

    public boolean hasColdMeal() {
        return checkIn.isInKitchenClosePeriod(KITCHEN_CLOSE_START_TIME, KITCHEN_CLOSE_END_TIME);
    }
}

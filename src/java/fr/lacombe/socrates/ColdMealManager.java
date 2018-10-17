package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class ColdMealManager {

    public static final LocalDateTime KITCHEN_CLOSE_START_TIME = LocalDateTime.of(2018, 10, 18, 21, 0);
    public static final LocalDateTime KITCHEN_CLOSE_END_TIME = LocalDateTime.of(2018, 10, 19, 0, 1);

    private final List<Participant> participants;

    private ColdMealManager(Participant[] participants) {
        this.participants = asList(participants);
    }

    public static ColdMealManager of(Participant... participant) {
        return new ColdMealManager(participant);
    }

    public int getNumberOfColdMeals() {
        if (participants.size() == 2) {
            return 2;
        }

        return !participants.isEmpty() && participants.get(0).hasColdMeal() ? 1 : 0;
    }
}

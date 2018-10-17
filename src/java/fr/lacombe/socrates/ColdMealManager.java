package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class ColdMealManager {

    private final KitchenCloseTimeProvider provider;
    private final List<Participant> participants;

    private ColdMealManager(KitchenCloseTimeProvider provider, Participant[] participants) {
        this.provider = provider;
        this.participants = asList(participants);
    }

    public static ColdMealManager of(KitchenCloseTimeProvider provider, Participant... participant) {
        return new ColdMealManager(provider, participant);
    }

    public long getNumberOfColdMeals() {
        LocalDateTime startTime = provider.getStartTime();
        LocalDateTime endTime = provider.getEndTime();

        return participants.stream().filter(participant -> participant.hasColdMeal(startTime, endTime)).count();
    }
}

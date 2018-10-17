package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class Participants {

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    static Participants of(Participant... participants) {
        return new Participants(asList(participants));
    }

    public int getColdMealNumber(LocalDateTime kitchenCloseTime, LocalDateTime receptionCloseTime) {

        return (int) participants.stream()
            .filter(participant -> participant.hasColdMeal(kitchenCloseTime, receptionCloseTime))
            .count();
    }
}

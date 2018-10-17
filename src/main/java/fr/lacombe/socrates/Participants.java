package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class Participants {

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(Participant... participants) {
        return new Participants(asList(participants));
    }

    public int getColdMealNumber(LocalDateTime startingTime, LocalDateTime endingTime) {

        int coldMealNumber = 0;

        for (Participant participant : participants) {
            if (participant.checkInTime.isKitchenClosedAndReceptionOpened(startingTime, endingTime)) {
                coldMealNumber++;
            }
        }

        return coldMealNumber;
    }
}

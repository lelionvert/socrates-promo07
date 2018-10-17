package fr.lacombe.socrates;

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

    public int getColdMealNumber() {

        int coldMealNumber = 0;

        for (Participant participant : participants)
            if(CheckInDate.of(participant.checkInTime).isKitchenClosed()) {
                coldMealNumber++;
            }

        return coldMealNumber;
    }
}

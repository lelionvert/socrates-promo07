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

    public static int getColdMealNumber(CheckInDate checkinDate) {

        if (checkinDate.getNumberOfColdMeals() > 0)
            return checkinDate.getNumberOfColdMeals();

        return 0;
    }

    public int getColdMealNumber() {

        int coldMealNumber = 0;

        for (Participant participant : participants)
            coldMealNumber += getColdMealNumber(CheckInDate.of(participant.checkInTime));

        return coldMealNumber;
    }
}

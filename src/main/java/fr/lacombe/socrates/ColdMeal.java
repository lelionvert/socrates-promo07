package fr.lacombe.socrates;

import java.util.List;

import static java.util.Arrays.asList;

public class ColdMeal {

    public static int getColdMealCounter(CheckInDate checkinDate) {

        if (checkinDate.getParticipantAfter9() > 0)
            return checkinDate.getParticipantAfter9();

        return 0;
    }

    public static int getColdMealCounter(Participant... participants) {

        int coldMealNumber = 0;
        List<Participant> participantList = asList(participants);

        for (Participant participant : participantList)
            coldMealNumber += getColdMealCounter(CheckInDate.of(participant.checkInTime));

        return coldMealNumber;
    }
}

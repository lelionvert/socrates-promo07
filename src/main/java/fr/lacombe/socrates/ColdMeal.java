package fr.lacombe.socrates;

public class ColdMeal {

    public static int getColdMealCounter(CheckinDate checkinDate) {

        if (checkinDate.getParticipantAfter9() > 0)
            return checkinDate.getParticipantAfter9();

        return 0;
    }
}

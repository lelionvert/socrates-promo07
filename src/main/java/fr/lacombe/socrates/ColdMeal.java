package fr.lacombe.socrates;

public class ColdMeal {

    public static int getColdMealCounter(int nbParticipant) {
        return getColdMealCounter2(nbParticipant, 0);
    }

    public static int getColdMealCounter2(int participantBefore9, int participantAfter9) {

        if (participantAfter9 == 3)
            return 3;
        if (participantAfter9 == 2)
            return 2;
        if (participantAfter9 == 1)
            return 1;

        return 0;
    }
}

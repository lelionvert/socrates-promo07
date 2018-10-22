package fr.lacombe.socrates.covers;

import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;

class Meals {

    static int calculateNumberOfVegetarianCovers(final Participant participant) {
        if (participant.getSojourn().start.getHour() == 23)
            return 0;
        if(participant.getDiet() != VEGETARIAN)
            return 0;
        return 1;
    }
}

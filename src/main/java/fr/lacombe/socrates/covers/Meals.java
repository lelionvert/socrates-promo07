package fr.lacombe.socrates.covers;

import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;

class Meals {

    static int calculateNumberOfVegetarianCovers(final Participant participant) {
        if(participant.getDiet() != VEGETARIAN || !participant.isParticipantPresent())
            return 0;
        return 1;
    }
}

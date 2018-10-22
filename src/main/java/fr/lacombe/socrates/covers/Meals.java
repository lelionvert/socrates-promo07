package fr.lacombe.socrates.covers;

import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;

class Meals {

    static int calculateNumberOfVegetarianCovers(final Participant participant, final Period meal) {
        if (participant.isPresent(meal) && participant.hasDiet(VEGETARIAN))
            return 1;
        return 0;
    }
}

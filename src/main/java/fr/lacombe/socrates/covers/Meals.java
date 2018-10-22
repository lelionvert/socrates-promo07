package fr.lacombe.socrates.covers;

import java.util.List;

import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;

class Meals {

    static int calculateNumberOfVegetarianCovers(final Participant participant, final List<Period> meals) {
        if (participant.hasDiet(VEGETARIAN))
            return (int) meals.stream().filter(participant::isPresent).count();

        return 0;
    }
}

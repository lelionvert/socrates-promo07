package fr.lacombe.socrates.covers;

import java.util.List;

import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;
import static java.util.stream.Collectors.toList;

class Meals {

    static int calculateNumberOfVegetarianCovers(final List<Participant> participants, final List<Period> meals) {
        final List<Participant> vegetarians = participants
                .stream()
                .filter(participant -> participant.hasDiet(VEGETARIAN))
                .collect(toList());

        return meals
                .stream()
                .mapToInt(meal -> (int) vegetarians.stream().filter(participant -> participant.isPresent(meal)).count())
                .sum();
    }
}

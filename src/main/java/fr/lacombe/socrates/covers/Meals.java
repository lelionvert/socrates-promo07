package fr.lacombe.socrates.covers;

import java.util.List;

import static java.util.stream.Collectors.toList;

class Meals {

    static List<Covers> calculateCovers(final List<Participant> participants, final List<Meal> meals) {
        return meals
                .stream()
                .map(meal -> Covers.of(
                        meal,
                        participants
                                .stream()
                                .filter(meal::hasParticipant)
                                .map(Participant::getDiet)
                                .collect(toList())
                ))
                .collect(toList());
    }
}

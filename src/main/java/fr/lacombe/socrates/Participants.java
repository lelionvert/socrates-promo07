package fr.lacombe.socrates;

import java.util.List;

class Participants {

    private final List<Participant> participants;

    private Participants(final List<Participant> participants) {
        this.participants = participants;
    }

    static Participants of(final List<Participant> participants) {
        return new Participants(participants);
    }

    long countColdMeals() {
        return participants
                .stream()
                .filter(Participant::hasColdMeal)
                .count();
    }
}

package fr.lacombe.socrates;

import java.util.List;

import static java.util.Arrays.asList;

class Participants {

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    static Participants of(Participant... participants) {
        return new Participants(asList(participants));
    }

    int getColdMealNumber() {
        return (int) participants.stream()
            .filter(Participant::hasColdMeal)
            .count();
    }
}

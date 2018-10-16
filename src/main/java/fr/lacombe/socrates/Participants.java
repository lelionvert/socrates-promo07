package fr.lacombe.socrates;

import java.util.List;

class Participants {

    private Participants() {
    }

    static Participants of(final List<Participant> participants) {
        return new Participants();
    }

    int countColdMeals() {
        return 0;
    }
}

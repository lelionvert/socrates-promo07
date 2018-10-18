package fr.lacombe.socrates;

class Participant {

    private final Accommodation accommodation;

    Participant(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    Price duePrice(MissedMeals missedMeals) {
        return accommodation.deduce(missedMeals.calculatePrice());
    }
}

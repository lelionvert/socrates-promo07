package fr.lacombe.socrates;

class Participant {

    private final Accommodation accommodation;

    Participant(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    Price duePrice(MissingMeals missingMeals) {
        return accommodation.deduce(missingMeals.calculatePrice());
    }
}

package fr.lacombe.socrates;

class Participant {

    private final Accommodation accommodation;

    Participant(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    Price duePrice(int numberOfMeals) {
        return accommodation.deduceMissingMeals(numberOfMeals);
    }
}

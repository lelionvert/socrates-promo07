package fr.lacombe.socrates;

class Participant {

    private final Accommodation accommodation;

    Participant(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    Price duePrice() {
        return accommodation.price;
    }

    Price duePrice(int numberOfMissedMeals) {
        if(numberOfMissedMeals == 2) {
            return Price.of(610 - 2*40);
        }
        return Price.of(610 - 40);
    }
}

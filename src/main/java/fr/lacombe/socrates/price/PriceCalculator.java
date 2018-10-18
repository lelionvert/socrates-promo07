package fr.lacombe.socrates.price;

class PriceCalculator {

    private final Accommodation accommodation;
    private final MissedMeals missedMeals;

    PriceCalculator(Accommodation accommodation, MissedMeals missedMeals) {
        this.accommodation = accommodation;
        this.missedMeals = missedMeals;
    }

    Price calculatePrice() {
        return accommodation.deduce(missedMeals.calculatePrice());
    }
}

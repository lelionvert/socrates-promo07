package fr.lacombe.socrates.pricecalculation;

public enum Accommodation {
    SINGLE(610),
    DOUBLE(510),
    TRIPLE(410),
    NO_ACCOMMODATION(240);

    private final int basePrice;

    Accommodation(int basePrice) {
        this.basePrice = basePrice;
    }

    public int computeParticipationPrice(int numberOfMissingMeals, int mealPrice) {
        return basePrice - numberOfMissingMeals * mealPrice;
    }
}

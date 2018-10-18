package fr.lacombe.socrates.pricecalculation;

public enum HostelBill {
    SINGLE(610),
    DOUBLE(510),
    TRIPLE(410),
    NO_ACCOMADATE(240);

    private final int basePrice;

    HostelBill(int basePrice) {
        this.basePrice = basePrice;
    }

    public int computeParticipationPrice(Journey journey) {
        int mealPrice = 40;
        return basePrice - journey.getNumberOfMissingMeals() * mealPrice;
    }
}

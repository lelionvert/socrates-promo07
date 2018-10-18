package fr.lacombe.socrates;

public enum Accommodation {
    SINGLE(Price.of(610)),
    DOUBLE(Price.of(510)),
    TRIPLE(Price.of(410)),
    NONE(Price.of(240));

    private static final Price MEAL_PRICE = Price.of(40);

    final Price price;

    Accommodation(Price price) {
        this.price = price;
    }

    public Price deduceMissingMeals(int numberOfMeals) {
        return price.deduce(MEAL_PRICE.multiply(numberOfMeals));
    }
}

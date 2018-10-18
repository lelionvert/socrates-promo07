package fr.lacombe.socrates.price;

public enum Accommodation {
    SINGLE(Price.of(610)),
    DOUBLE(Price.of(510)),
    TRIPLE(Price.of(410)),
    NONE(Price.of(240));

    final Price price;

    Accommodation(Price price) {
        this.price = price;
    }

    public Price deduce(Price price) {
        return this.price.deduce(price);
    }
}

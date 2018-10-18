package fr.lacombe.socrates;

import java.util.Objects;

class Price {

    private final int value;

    private Price(int value) {
        this.value = value;
    }

    static Price of(int value) {
        return new Price(value);
    }

    Price deduce(int value) {
        return Price.of(this.value - value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value == price.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

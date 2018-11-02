package fr.lacombe.socrates.covers_participants;

import java.util.Objects;

class Covers {

    private final int numberOfHotMeals;

    public Covers(final int numberOfHotMeals) {
        this.numberOfHotMeals = numberOfHotMeals;
    }

    static Covers of(final int numberOfColdMeals, final int numberOfHotMeals) {
        return new Covers(numberOfHotMeals);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Covers covers = (Covers) o;
        return numberOfHotMeals == covers.numberOfHotMeals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfHotMeals);
    }
}

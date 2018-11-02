package fr.lacombe.socrates.covers_participants;

import java.util.Objects;

class Covers {

    private final int numberOfColdMeals;
    private final int numberOfHotMeals;

    public Covers(final int numberOfColdMeals, final int numberOfHotMeals) {
        this.numberOfColdMeals = numberOfColdMeals;
        this.numberOfHotMeals = numberOfHotMeals;
    }

    static Covers of(final int numberOfColdMeals, final int numberOfHotMeals) {
        return new Covers(numberOfColdMeals, numberOfHotMeals);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Covers covers = (Covers) o;
        return numberOfColdMeals == covers.numberOfColdMeals &&
                numberOfHotMeals == covers.numberOfHotMeals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfColdMeals, numberOfHotMeals);
    }

    @Override
    public String toString() {
        return "Covers{" +
                "numberOfColdMeals=" + numberOfColdMeals +
                ", numberOfHotMeals=" + numberOfHotMeals +
                '}';
    }
}

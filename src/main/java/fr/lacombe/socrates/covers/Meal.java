package fr.lacombe.socrates.covers;

import java.util.Objects;

class Meal {

    private final Period period;

    private Meal(final Period period) {
        this.period = period;
    }

    static Meal of(final Period period) {
        return new Meal(period);
    }

    boolean hasParticipant(final Participant participant) {
        return participant.isPresent(period);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Meal meal = (Meal) o;
        return Objects.equals(period, meal.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(period);
    }

    @Override
    public String toString() {
        return "[" + period + "]";
    }
}

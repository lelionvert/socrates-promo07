package fr.lacombe.socrates.covers;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Meal {

    private final Period period;

    private Meal(final Period period) {
        this.period = period;
    }

    static Meal of(final Period period) {
        return new Meal(period);
    }
    
    Map<Diet, Long> groupDietsByParticipants(final List<Participant> participants) {
        return participants
                .stream()
                .filter(participant -> participant.isPresent(period))
                .collect(groupingBy(Participant::getDiet, counting()));
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

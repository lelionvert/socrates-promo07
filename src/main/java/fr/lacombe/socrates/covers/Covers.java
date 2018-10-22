package fr.lacombe.socrates.covers;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

class Covers {

    private final Meal meal;
    private final Map<Diet, Long> diets;

    private Covers(final Meal meal, final Map<Diet, Long> diets) {
        this.meal = meal;
        this.diets = diets;
    }

    static Covers of(final Meal meal, final Map<Diet, Long> diets) {
        return new Covers(meal, diets);
    }

    static List<Covers> from(final List<Meal> meals, final List<Participant> participants) {
        return meals
                .stream()
                .map(meal -> of(meal, meal.groupDietsByParticipants(participants)))
                .collect(toList());
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Covers covers = (Covers) o;
        return Objects.equals(meal, covers.meal) &&
                Objects.equals(diets, covers.diets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meal, diets);
    }

    @Override
    public String toString() {
        return meal + "\n" + diets + "\n\n";
    }
}

package fr.lacombe.socrates.mocked_covers;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

import static java.util.Collections.emptyMap;

class CoversByDietByMeal {

    private final Map<Object, Object> coversByDietByMeal;

    private CoversByDietByMeal(final Map<Object, Object> coversByDietByMeal) {
        this.coversByDietByMeal = coversByDietByMeal;
    }

    static CoversByDietByMeal of(final Map<Meal, CoversByDiet> coversByDietByMeal) {
        return new CoversByDietByMeal(emptyMap());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CoversByDietByMeal that = (CoversByDietByMeal) o;
        return Objects.equals(coversByDietByMeal, that.coversByDietByMeal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coversByDietByMeal);
    }
}

package fr.lacombe.socrates.diets;

import java.util.HashMap;
import java.util.Map;

class CoversByDiet {

    private final Map<Diet, Integer> coversByDiet;

    private CoversByDiet(final Map<Diet, Integer> coversByDiet) {
        this.coversByDiet = coversByDiet;
    }

    static CoversByDiet of(final Map<Diet, Integer> coversByDiet) {
        return new CoversByDiet(new HashMap<>(coversByDiet));
    }

    int getCoversBy(final Diet diet) {
        return coversByDiet.computeIfAbsent(diet, key -> 0);
    }
}

package fr.lacombe.socrates.mocked_covers;

import java.time.LocalDateTime;
import java.util.Map;

public class CoversByDiet {
    private final Map<Diet, Integer> diets;

    public CoversByDiet(final Map<Diet, Integer> diets) {
        this.diets = diets;
    }

    public static CoversByDiet of(final Map<Diet, Integer> diets) {
        return new CoversByDiet(diets);
    }
}

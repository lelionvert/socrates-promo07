package fr.lacombe.socrates.diets;

import java.util.Collection;

class Covers {

    private final Collection<Diet> diets;

    private Covers(final Collection<Diet> diets) {
        this.diets = diets;
    }

    static Covers of(final Collection<Diet> diets) {
        return new Covers(diets);
    }

    CoversByDiet countByDiet() {
        return diets.stream().collect(new CoversByDietCollector());
    }
}

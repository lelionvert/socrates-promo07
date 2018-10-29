package fr.lacombe.socrates.mocked_covers;

import java.util.Collections;

import static java.util.Collections.emptyMap;

public class CoversAction {
    private final Covers covers;
    private final DietByMeal dietByMeal;

    private CoversAction(final Covers covers, final DietByMeal dietByMeal) {
        this.covers = covers;
        this.dietByMeal = dietByMeal;
    }

    public static CoversAction of(final IYoloDataSource iYoloDataSource, final Covers covers, final DietByMeal dietByMeal) {
        return new CoversAction(covers, dietByMeal);
    }

    CoversByDietByMeal execute() {
        return CoversByDietByMeal.of(emptyMap());
    }
}

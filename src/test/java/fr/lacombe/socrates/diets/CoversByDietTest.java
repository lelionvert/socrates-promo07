package fr.lacombe.socrates.diets;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static fr.lacombe.socrates.diets.Diet.OMNIVOROUS;
import static fr.lacombe.socrates.diets.Diet.VEGETARIAN;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;

public class CoversByDietTest {

    @Test
    public void should_get_zero_cover_when_there_is_no_corresponding_diet() {
        final CoversByDiet coversByDiet = CoversByDiet.of(emptyMap());

        final int result = coversByDiet.getCoversBy(OMNIVOROUS);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_get_one_cover_when_there_is_one_corresponding_diet() {
        final CoversByDiet coversByDiet = CoversByDiet.of(singletonMap(OMNIVOROUS, 1));

        final int result = coversByDiet.getCoversBy(OMNIVOROUS);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_get_multiple_covers_when_there_is_one_corresponding_diet() {
        final CoversByDiet coversByDiet = CoversByDiet.of(singletonMap(OMNIVOROUS, 2));

        final int result = coversByDiet.getCoversBy(OMNIVOROUS);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_get_multiple_covers_when_there_is_multiple_corresponding_diets() {
        final Map<Diet, Integer> diets = new HashMap<>();
        diets.put(OMNIVOROUS, 3);
        diets.put(VEGETARIAN, 5);

        final CoversByDiet coversByDiet = CoversByDiet.of(diets);

        assertThat(coversByDiet.getCoversBy(OMNIVOROUS)).isEqualTo(3);
        assertThat(coversByDiet.getCoversBy(VEGETARIAN)).isEqualTo(5);
    }
}
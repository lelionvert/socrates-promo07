package fr.lacombe.socrates.covers;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MealsTest {

    @Test
    public void should_calculate_the_number_of_vegetarian_covers() {
        final Diet diet = Diet.VEGETARIAN;

        final int result = Meals.calculateNumberOfVegetarianCovers(new Participant(diet, true));

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_2() {
        final Diet diet = Diet.VEGAN;

        final int result = Meals.calculateNumberOfVegetarianCovers(new Participant(diet, true));

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_3() {
        final Diet diet = Diet.VEGETARIAN;

        final int result = Meals.calculateNumberOfVegetarianCovers(new Participant(diet, false));

        assertThat(result).isEqualTo(0);
    }
}

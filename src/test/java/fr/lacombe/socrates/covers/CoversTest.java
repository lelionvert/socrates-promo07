package fr.lacombe.socrates.covers;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.lacombe.socrates.covers.Diet.VEGAN;
import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;
import static java.time.Month.OCTOBER;
import static java.util.Arrays.asList;
import static java.util.Collections.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CoversTest {

    @Test
    public void should_get_the_covers_diets_for_one_meal_with_one_participant() {
        final List<Meal> meals = singletonList(Meal.of(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        )));
        final List<Participant> participants = singletonList(Participant.of(
                Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ),
                VEGETARIAN
        ));

        final List<Covers> result = Covers.from(meals, participants);

        assertThat(result).isEqualTo(singletonList(
                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                        )),
                        singletonMap(VEGETARIAN, 1L)
                )
        ));
    }

    @Test
    public void should_get_empty_covers_diets_for_one_meal_without_participant() {
        final List<Meal> meals = singletonList(Meal.of(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        )));
        final List<Participant> participants = singletonList(Participant.of(
                Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 23, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ),
                VEGETARIAN
        ));

        final List<Covers> result = Covers.from(meals, participants);

        assertThat(result).isEqualTo(singletonList(
                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                        )),
                        emptyMap()
                )
        ));
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_for_a_vegetarian_participant_in_numerous_meals() {
        final List<Meal> meals = asList(
                Meal.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                )),
                Meal.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 19, 12, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 19, 14, 0, 0)
                ))
        );
        final List<Participant> participants = singletonList(Participant.of(
                Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ),
                VEGETARIAN
        ));

        final List<Covers> result = Covers.from(meals, participants);

        assertThat(result).isEqualTo(asList(
                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                        )),
                        singletonMap(VEGETARIAN, 1L)
                ),

                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 19, 12, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 19, 14, 0, 0)
                        )),
                        singletonMap(VEGETARIAN, 1L)
                )
        ));
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_for_multiple_participants_in_one_meal() {
        final List<Meal> meals = singletonList(Meal.of(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        )));

        final List<Participant> participants = asList(
                Participant.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ), VEGETARIAN),
                Participant.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 19, 10, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ), VEGETARIAN)
        );

        final List<Covers> result = Covers.from(meals, participants);

        assertThat(result).isEqualTo(singletonList(
                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                        )),
                        singletonMap(VEGETARIAN, 1L)
                )
        ));
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_for_multiple_participants_in_one_meal_2() {
        final List<Meal> meals = singletonList(Meal.of(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        )));

        final List<Participant> participants = asList(
                Participant.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ), VEGAN),
                Participant.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 19, 10, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ), VEGETARIAN)
        );

        final List<Covers> result = Covers.from(meals, participants);

        assertThat(result).isEqualTo(singletonList(
                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                        )),
                        singletonMap(VEGAN, 1L)
                )
        ));
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_for_multiple_participants_in_one_meal_32() {
        final List<Meal> meals = singletonList(Meal.of(Period.of(
                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
        )));

        final List<Participant> participants = asList(
                Participant.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ), VEGAN),
                Participant.of(Period.of(
                        LocalDateTime.of(2018, OCTOBER, 18, 15, 0, 0),
                        LocalDateTime.of(2018, OCTOBER, 21, 15, 0, 0)
                ), VEGETARIAN)
        );

        final List<Covers> result = Covers.from(meals, participants);

        final Map<Diet, Long> diets = new HashMap<>();
        diets.put(VEGAN, 1L);
        diets.put(VEGETARIAN, 1L);
        assertThat(result).isEqualTo(singletonList(
                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                        )),
                        diets
                )
        ));
    }
}

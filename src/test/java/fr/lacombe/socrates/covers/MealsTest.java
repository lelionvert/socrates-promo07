package fr.lacombe.socrates.covers;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static fr.lacombe.socrates.covers.Diet.VEGAN;
import static fr.lacombe.socrates.covers.Diet.VEGETARIAN;
import static java.time.Month.OCTOBER;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class MealsTest {

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_when_a_vegetarian_participant_is_present() {
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
                        singletonList(VEGETARIAN)
                )
        ));
    }

    @Test
    public void should_calculate_the_number_of_vegetarian_covers_no_vegetarian_participant_is_present() {
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
                        emptyList()
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
                        singletonList(VEGETARIAN)
                ),

                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 19, 12, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 19, 14, 0, 0)
                        )),
                        singletonList(VEGETARIAN)
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
                        singletonList(VEGETARIAN)
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
                        singletonList(VEGAN)
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

        assertThat(result).isEqualTo(singletonList(
                Covers.of(
                        Meal.of(Period.of(
                                LocalDateTime.of(2018, OCTOBER, 18, 19, 0, 0),
                                LocalDateTime.of(2018, OCTOBER, 18, 21, 0, 0)
                        )),
                        asList(VEGAN, VEGETARIAN)
                )
        ));
    }
}

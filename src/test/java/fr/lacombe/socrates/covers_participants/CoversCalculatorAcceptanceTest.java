package fr.lacombe.socrates.covers_participants;

import fr.lacombe.socrates.diets.Diet;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import static java.time.Month.NOVEMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CoversCalculatorAcceptanceTest {

    private static final LocalDate FIRST_DAY_OF_CONFERENCE = LocalDate.of(2018, NOVEMBER, 1);
    private static final LocalDate LAST_DAY_OF_CONFERENCE = LocalDate.of(2018, NOVEMBER, 4);
    private static final LocalTime START_HOUR_OF_LUNCH = LocalTime.of(12, 0);
    private static final LocalTime END_HOUR_OF_DINER = LocalTime.of(22, 0);

    private ConferenceConfiguration conferenceConfiguration;

    @Before
    public void setUp() {
        this.conferenceConfiguration = mock(ConferenceConfiguration.class);
        when(conferenceConfiguration.getStartDay()).thenReturn(FIRST_DAY_OF_CONFERENCE);
        when(conferenceConfiguration.getEndDay()).thenReturn(LAST_DAY_OF_CONFERENCE);
        when(conferenceConfiguration.getStartHourOfLunch()).thenReturn(START_HOUR_OF_LUNCH);
        when(conferenceConfiguration.getEndHourOfDiner()).thenReturn(END_HOUR_OF_DINER);
    }

    @Test
    public void should_calculate_the_number_of_hot_and_cold_covers_for_one_participant() {
        final Participant participant = Participant.of(
                Email.of("toto@toto.fr"),
                Diet.PESCETARIAN,
                LocalDateTime.of(2018, Month.NOVEMBER, 1, 23, 0),
                LocalDateTime.of(2018, Month.NOVEMBER, 4, 10, 0)
        );

        final Covers result = new CoversCalculator(conferenceConfiguration).compute(participant);

        assertThat(result).isEqualTo(Covers.of(2, 4));
    }
}

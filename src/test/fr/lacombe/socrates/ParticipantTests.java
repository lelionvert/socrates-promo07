package fr.lacombe.socrates;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTests {

    class CheckInFalseMock extends CheckIn {

        public CheckInFalseMock() {
            super(null);
        }

        @Override
        boolean isInKitchenClosePeriod(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
            return false;
        }
    }

    class CheckInTrueMock extends CheckIn {

        public CheckInTrueMock() {
            super(null);
        }

        @Override
        boolean isInKitchenClosePeriod(LocalDateTime kitchenCloseStartTime, LocalDateTime kitchenCloseEndTime) {
            return true;
        }
    }

    private TestKitchenCloseTimeProvider provider = new TestKitchenCloseTimeProvider();

    @Test
    public void should_have_no_cold_meal_when_is_not_in_kitchen_closed_period() {
        Participant participant = new Participant("Francis", new CheckInFalseMock());

        boolean result = participant.hasColdMeal(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isFalse();
    }

    @Test
    public void should_have_cold_meal_when_is_in_kitchen_closed_period() {
        Participant participant = new Participant("Francis", new CheckInTrueMock());

        boolean result = participant.hasColdMeal(provider.getStartTime(), provider.getEndTime());

        assertThat(result).isTrue();
    }
}

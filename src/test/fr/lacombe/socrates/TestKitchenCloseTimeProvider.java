package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class TestKitchenCloseTimeProvider implements KitchenCloseTimeProvider {

    @Override
    public LocalDateTime getStartTime() {
        return LocalDateTime.of(2018, 10, 18, 21, 0);
    }

    @Override
    public LocalDateTime getEndTime() {
        return LocalDateTime.of(2018, 10, 19, 0, 1);
    }
}

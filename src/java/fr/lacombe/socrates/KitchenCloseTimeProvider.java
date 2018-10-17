package fr.lacombe.socrates;

import java.time.LocalDateTime;

public interface KitchenCloseTimeProvider {

    LocalDateTime getStartTime();

    LocalDateTime getEndTime();
}

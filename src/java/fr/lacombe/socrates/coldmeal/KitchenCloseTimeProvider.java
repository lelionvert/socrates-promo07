package fr.lacombe.socrates.coldmeal;

import java.time.LocalDateTime;

public interface KitchenCloseTimeProvider {

    LocalDateTime getStartTime();

    LocalDateTime getEndTime();
}

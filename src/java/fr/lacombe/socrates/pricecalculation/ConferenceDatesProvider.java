package fr.lacombe.socrates.pricecalculation;

import java.time.LocalDateTime;

public interface ConferenceDatesProvider {

    LocalDateTime getBeginning();
    LocalDateTime getEnding();
}

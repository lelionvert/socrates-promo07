package fr.lacombe.socrates.pricecalculation;

import java.time.LocalDateTime;

public class Journey {
    private Journey() {
    }

    public static Journey of(LocalDateTime checkIn, LocalDateTime checkOut) {
        return new Journey();
    }
}

package fr.lacombe.socrates.mocked_covers;

import java.time.LocalDateTime;

public class Meal {

    static Meal of(LocalDateTime start, LocalDateTime end) {
        return new Meal();
    }
}

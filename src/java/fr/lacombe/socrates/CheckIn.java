package fr.lacombe.socrates;

import java.time.LocalDateTime;

public class CheckIn {

    private final LocalDateTime time;

    public CheckIn(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }
}

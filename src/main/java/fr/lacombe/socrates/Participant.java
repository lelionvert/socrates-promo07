package fr.lacombe.socrates;

import java.time.LocalDateTime;

class Participant {
    public final LocalDateTime checkInTime;

    public Participant(LocalDateTime checkInTime) {

        this.checkInTime = checkInTime;
    }
}

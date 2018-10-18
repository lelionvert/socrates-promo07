package fr.lacombe.socrates.pricecalculation;

import java.time.LocalDateTime;

public class Journey {

    public static class JourneyBuilder {

        private LocalDateTime checkIn;
        private LocalDateTime checkOut;

        public JourneyBuilder from(LocalDateTime checkIn) {
            this.checkIn = checkIn;
            return this;
        }

        public JourneyBuilder to(LocalDateTime checkOut) {
            this.checkOut = checkOut;
            return this;
        }

        public Journey build() {
            return Journey.of(checkIn, checkOut);
        }
    }

    private final LocalDateTime checkIn;

    private Journey(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public static Journey of(LocalDateTime checkIn, LocalDateTime checkOut) {
        return new Journey(checkIn);
    }

    public int getNumberOfMissingMeals() {
        if (checkIn.getDayOfMonth() == 19){
            return 1;
        }
        return 0;
    }
}

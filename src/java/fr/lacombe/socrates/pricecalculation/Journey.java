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
    private final LocalDateTime checkOut;

    private Journey(LocalDateTime checkIn, LocalDateTime checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public static Journey of(LocalDateTime checkIn, LocalDateTime checkOut) {
        return new Journey(checkIn, checkOut);
    }

    public int getNumberOfMissingMeals(ConferenceDatesProvider conferenceDatesProvider) {
        int numberOfMissingMeals = 0;
        int confBeginningDay = conferenceDatesProvider.getBeginning().getDayOfMonth();
        int confEndingDay = conferenceDatesProvider.getEnding().getDayOfMonth();

        if (checkIn.getDayOfMonth() == confBeginningDay + 1) {
            numberOfMissingMeals++;
        }
        if (checkOut.getDayOfMonth() == confEndingDay - 1) {
            numberOfMissingMeals++;
        }
        return numberOfMissingMeals;
    }
}

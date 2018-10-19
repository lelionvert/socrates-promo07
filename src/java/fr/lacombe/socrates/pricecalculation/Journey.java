package fr.lacombe.socrates.pricecalculation;

import java.time.LocalDateTime;
import java.time.Period;

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
        int confBeginningDay = conferenceDatesProvider.getBeginning().getDayOfMonth();
        int confEndingDay = conferenceDatesProvider.getEnding().getDayOfMonth();

        int totalMissingMeals = getBeginningMissingMeals(confBeginningDay) + getEndingMissingMeals(confEndingDay);
        return max(totalMissingMeals);
    }

    private int max(int totalMissingMeals) {
        if (totalMissingMeals > 2) {
            return 2;
        }

        return totalMissingMeals;
    }

    private int getBeginningMissingMeals(int confBeginningDay) {
        int difference = checkIn.getDayOfMonth() - confBeginningDay;
        if (difference > 0 && checkIn.getHour() >= 14) {
            difference += 1;
        }
        return difference;
    }

    private int getEndingMissingMeals(int confEndingDay) {
        int difference = confEndingDay - checkOut.getDayOfMonth();
        if (difference > 0 && checkOut.getHour() < 18) {
            difference += 1;
        }
        return difference;
    }
}

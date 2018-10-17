package fr.lacombe.socrates;

import java.time.LocalDateTime;

class Venue {
    private final LocalDateTime startColdMealDistribution;
    private final LocalDateTime endColdMealDistribution;

    Venue(LocalDateTime startColdMealDistribution, LocalDateTime endColdMealDistribution) {
        this.startColdMealDistribution = startColdMealDistribution;
        this.endColdMealDistribution = endColdMealDistribution;
    }

    boolean arrivedDateIsAfterStartColdMealDistribution(LocalDateTime arrivedDate) {
        return arrivedDate.isAfter(startColdMealDistribution);
    }

    boolean arrivedDateIsBeforeEndColdMealDistribution(LocalDateTime arrivedDate) {
        return arrivedDate.isBefore(endColdMealDistribution);
    }
}

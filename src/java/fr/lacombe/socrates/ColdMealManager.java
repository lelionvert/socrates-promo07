package fr.lacombe.socrates;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class ColdMealManager {

    private final KitchenCloseTimeProvider provider;
    private final List<CheckIn> checkIns;

    private ColdMealManager(KitchenCloseTimeProvider provider, CheckIn[] checkIns) {
        this.provider = provider;
        this.checkIns = asList(checkIns);
    }

    public static ColdMealManager of(KitchenCloseTimeProvider provider, CheckIn... checkIns) {
        return new ColdMealManager(provider, checkIns);
    }

    public long getNumberOfColdMeals() {
        LocalDateTime startTime = provider.getStartTime();
        LocalDateTime endTime = provider.getEndTime();

        return checkIns
                .stream()
                .filter(checkIn -> checkIn.isInKitchenClosePeriod(startTime, endTime))
                .count();
    }
}

package fr.lacombe.socrates.coldmeal;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class Kitchen {

    private final KitchenCloseTimeProvider kitchenCloseTimeProvider;
    private final List<CheckIn> checkIns;

    private Kitchen(KitchenCloseTimeProvider kitchenCloseTimeProvider, CheckIn[] checkIns) {
        this.kitchenCloseTimeProvider = kitchenCloseTimeProvider;
        this.checkIns = asList(checkIns);
    }

    public static Kitchen of(KitchenCloseTimeProvider kitchenCloseTimeProvider, CheckIn... checkIns) {
        return new Kitchen(kitchenCloseTimeProvider, checkIns);
    }

    public long getNumberOfColdMeals() {
        LocalDateTime startTime = kitchenCloseTimeProvider.getStartTime();
        LocalDateTime endTime = kitchenCloseTimeProvider.getEndTime();

        return checkIns
                .stream()
                .filter(checkIn -> checkIn.isInKitchenClosePeriod(startTime, endTime))
                .count();
    }
}

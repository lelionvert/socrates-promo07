package fr.lacombe.socrates.pricecalculation;

public class Conference {

    private final int mealPerDay;
    private final int lunchHour;
    private final int dinnerHour;
    private final int endLunchHour;

    private Conference(int mealPerDay, int lunchHour, int dinnerHour, int endLunchHour) {
        this.mealPerDay = mealPerDay;
        this.lunchHour = lunchHour;
        this.dinnerHour = dinnerHour;
        this.endLunchHour = endLunchHour;
    }

    public static Conference of(int mealPerDay, int lunchHour, int endLunchHour, int dinnerHour) {
        return new Conference(mealPerDay, lunchHour, dinnerHour, endLunchHour);
    }

    public int computeNumberOfMeals(PeriodWithTime period) {
        int numberOfMeals = period.getDays() * mealPerDay;

        if (period.isEndingAfter(lunchHour)) {
            numberOfMeals++;
        }
        if (period.isEndingAfter(dinnerHour)) {
            numberOfMeals++;
        }
        if (period.isStartingAfter(endLunchHour)) {
            numberOfMeals--;
        }

        return numberOfMeals;
    }
}

package fr.lacombe.socrates.pricecalculation;

public class Conference {

    private final int mealPerDay;
    private final int lunchHour;
    private final int dinnerHour;

    private Conference(int mealPerDay, int lunchHour, int dinnerHour) {
        this.mealPerDay = mealPerDay;
        this.lunchHour = lunchHour;
        this.dinnerHour = dinnerHour;
    }

    public static Conference of(int mealPerDay, int lunchHour, int dinnerHour) {
        return new Conference(mealPerDay, lunchHour, dinnerHour);
    }

    public int computeNumberOfMeals(PeriodWithTime period) {
        int numberOfMeals = period.getDays() * mealPerDay;

        if (period.getEndingHour() >= lunchHour) {
            numberOfMeals++;
        }
        if (period.getEndingHour() >= dinnerHour) {
            numberOfMeals++;
        }

        return numberOfMeals;
    }
}

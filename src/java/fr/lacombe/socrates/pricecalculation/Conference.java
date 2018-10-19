package fr.lacombe.socrates.pricecalculation;

public class Conference {

    public int computeNumberOfMeals(PeriodWithTime period) {
        int numberOfMeals = period.getDays() * 2;
        if (period.getEndingHour() >= 12) {
            numberOfMeals++;
        }

        return numberOfMeals;
    }
}

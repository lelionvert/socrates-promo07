package fr.lacombe.socrates.pricecalculation;

import java.time.LocalDateTime;
import java.time.Period;

public class PeriodWithTime {

    private final LocalDateTime start;
    private final LocalDateTime end;
    private final Period period;

    private PeriodWithTime(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
        this.period = Period.between(start.toLocalDate(), end.toLocalDate());
    }


    public static PeriodWithTime between(LocalDateTime start, LocalDateTime end) {
        return new PeriodWithTime(start, end);
    }

    public int getDays() {
        return period.getDays();
    }

    public boolean isEndingAfter(int lunchHour) {
        return end.getHour() >= lunchHour;
    }

    public boolean isStartingAfter(int endLunchHour) {
        return start.getHour() >= endLunchHour;
    }
}

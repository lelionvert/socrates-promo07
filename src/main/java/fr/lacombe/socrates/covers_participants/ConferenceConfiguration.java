package fr.lacombe.socrates.covers_participants;

import java.time.LocalDate;
import java.time.LocalTime;

interface ConferenceConfiguration {

    LocalDate getStartDay();
    LocalDate getEndDay();

    LocalTime getStartHourOfLunch();
    LocalTime getEndHourOfDiner();
}

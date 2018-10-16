package fr.lacombe.socrates;

class Participant {

    private final String name;
    private final CheckInDate checkInDate;

    Participant(final String name, final CheckInDate checkInDate) {
        this.name = name;
        this.checkInDate = checkInDate;
    }

    boolean hasColdMeal() {
        return checkInDate.isThursdayEvening();
    }
}

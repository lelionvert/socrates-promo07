package fr.lacombe.socrates.pricecalculation;

public class Participant {

    private final Journey journey;
    private final RoomChoice roomChoice;

    private Participant(Journey journey, RoomChoice roomChoice) {
        this.journey = journey;
        this.roomChoice = roomChoice;
    }

    public static Participant of(Journey journey, RoomChoice roomChoice) {
        return new Participant(journey, roomChoice);
    }

    public int getParticipationPrice() {
        return roomChoice.calculateParticipationPrice(journey);
    }
}

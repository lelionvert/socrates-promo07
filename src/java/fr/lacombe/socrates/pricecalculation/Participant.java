package fr.lacombe.socrates.pricecalculation;

public class Participant {

    private final Journey journey;
    private final Accommodation accommodation;

    private Participant(Journey journey, Accommodation accommodation) {
        this.journey = journey;
        this.accommodation = accommodation;
    }

    public static Participant of(Journey journey, Accommodation accommodation) {
        return new Participant(journey, accommodation);
    }

    public int computeParticipationPrice() {
        return accommodation.computeParticipationPrice(journey.getNumberOfMissingMeals(), 40);
    }
}

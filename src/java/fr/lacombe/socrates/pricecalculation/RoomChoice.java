package fr.lacombe.socrates.pricecalculation;

public enum RoomChoice {
    SINGLE(610),
    DOUBLE(510);

    private final int basePrice;

    RoomChoice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int calculateParticipationPrice(Journey journey) {
        return basePrice;
    }
}

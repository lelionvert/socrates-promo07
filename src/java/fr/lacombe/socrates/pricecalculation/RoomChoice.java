package fr.lacombe.socrates.pricecalculation;

public enum RoomChoice {
    SINGLE(610),
    DOUBLE(510),
    TRIPLE(410),
    NO_ACCOMADATE(240);

    private final int basePrice;

    RoomChoice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int calculateParticipationPrice(Journey journey) {
        return basePrice;
    }
}

package fr.lacombe.socrates.pricecalculation;

public class Participant {

    private final Journey journey;
    private final HostelBill hostelBill;

    private Participant(Journey journey, HostelBill hostelBill) {
        this.journey = journey;
        this.hostelBill = hostelBill;
    }

    public static Participant of(Journey journey, HostelBill hostelBill) {
        return new Participant(journey, hostelBill);
    }

    public int computeParticipationPrice() {
        return hostelBill.computeParticipationPrice(journey);
    }
}

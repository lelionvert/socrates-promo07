package fr.lacombe.socrates;

class Participant {

    private final Accommodation accommodation;

    Participant(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    Price duePrice() {
        if(accommodation == Accommodation.NONE) {
            return Price.of(240);
        }
        if(accommodation == Accommodation.TRIPLE) {
            return Price.of(410);
        }
        if(accommodation == Accommodation.DOUBLE) {
            return Price.of(510);
        }
        return Price.of(610);
    }
}

package fr.lacombe.socrates;

class Participant {

    static final int SINGLE_ACCOMMODATION = 1;
    static final int DOUBLE_ACCOMMODATION = 2;
    static final int TRIPLE_ACCOMMODATION = 3;
    static final int NO_ACCOMMODATION = 4;

    private final int accommodationType;

    Participant(int accommodationType) {
        this.accommodationType = accommodationType;
    }

    Price duePrice() {
        if(accommodationType == NO_ACCOMMODATION) {
            return Price.of(240);
        }
        if(accommodationType == TRIPLE_ACCOMMODATION) {
            return Price.of(410);
        }
        if(accommodationType == DOUBLE_ACCOMMODATION) {
            return Price.of(510);
        }
        return Price.of(610);
    }
}

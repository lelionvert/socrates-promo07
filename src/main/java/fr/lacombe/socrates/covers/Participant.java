package fr.lacombe.socrates.covers;

class Participant {

    private final Period sojourn;
    private final Diet diet;

    private Participant(final Period sojourn, final Diet diet) {
        this.sojourn = sojourn;
        this.diet = diet;
    }

    static Participant of(final Period sojourn, final Diet diet) {
        return new Participant(sojourn, diet);
    }

    boolean isPresent(final Period period) {
        return sojourn.contains(period);
    }

    Diet getDiet() {
        return diet;
    }
}

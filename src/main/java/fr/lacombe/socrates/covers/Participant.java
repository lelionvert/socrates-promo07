package fr.lacombe.socrates.covers;

class Participant {
    private final Diet diet;
    private final boolean isParticipantPresent;

    Participant(final Diet diet, final boolean isParticipantPresent) {
        this.diet = diet;
        this.isParticipantPresent = isParticipantPresent;
    }

    Diet getDiet() {
        return diet;
    }

    boolean isParticipantPresent() {
        return isParticipantPresent;
    }
}

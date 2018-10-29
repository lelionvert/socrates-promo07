package fr.lacombe.socrates.mocked_covers;

import java.util.List;

public interface DietByMeal {
    List<Diet> get(Meal meal, List<Participant> participants);
}

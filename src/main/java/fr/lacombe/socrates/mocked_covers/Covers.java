package fr.lacombe.socrates.mocked_covers;

import java.util.List;

public interface Covers {
    CoversByDiet get(List<Diet> diets);
}

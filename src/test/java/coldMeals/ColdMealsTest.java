package coldMeals;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ColdMealsTest {

    @Test
    public void should_return_no_meal_when_no_participant() {

        //GIVEN
        List<Participant> participants = new ArrayList();

        //WHEN
        int coldMeals = Meal.checkMeal(participants);

        //THEN
        Assertions.assertThat(coldMeals).isEqualTo(0);
    }
}

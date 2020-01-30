package model.habit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HabitRecommender {
    private Map<Category, HabitList> habitCategories = new HashMap<>();

    public HabitRecommender() {
    }

    // EFFECTS: return list of habits belonging to the same category as habit
    public HabitList suggestHabits(Habit habit) {
        HabitList listOfHabits = habitCategories.get(habit.key);
        return listOfHabits;
    }
}

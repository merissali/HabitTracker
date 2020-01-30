package model;

import model.habit.Category;
import model.habit.Habit;
import model.habit.HabitRecommender;
import model.habit.HabitSorter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabitRecommenderTest {
    HabitRecommender habitRecommender = new HabitRecommender();
    private Map<Category, ArrayList<Habit>> habitCategories = new HashMap<>();
    HabitSorter habitSorter = new HabitSorter();


    @Test
    public void testConstructor() {
        assertEquals(0, habitCategories.size());
    }

//    @Test
//    public void testSuggestHabits() {
//        Category personal = new Category("personal");
//        Habit habit = new Habit("h");
//        Habit habit1 = new Habit("h1");
//        habitCategories.addHabitRelation(personal);
////        ArrayList<Habit> listOfHabits = habitCategories.get(personal);
//        habitSorter.addHabitRelation(personal, habit);
//        assertTrue(habitSorter.getMap().get(personal).contains(habit));
//        habitSorter.addHabitRelation(personal, habit1);
//        assertTrue(habitSorter.getMap().get(personal).contains(habit1));
//        assertEquals(habit1,habitRecommender.suggestHabits(habit));
//    }
}

package model;

import model.habit.Category;
import model.habit.Habit;
import model.habit.HabitPrinter;
import model.habit.HabitSorter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HabitPrinterTest {
    HabitSorter habitSorter = new HabitSorter();
    HabitPrinter habitPrinter = new HabitPrinter();
    private Map<Category, ArrayList<Habit>> habitCategories = new HashMap<>();
    ArrayList<Category> categories = new ArrayList<>();

    @Test
    public void testPrintHabits() {
        assertEquals("Habits printed!", habitPrinter.printHabits("personal"));
    }

    @Test
    public void testPrintAllEmpty() {
        assertEquals("[]", habitPrinter.printAll());
    }


}

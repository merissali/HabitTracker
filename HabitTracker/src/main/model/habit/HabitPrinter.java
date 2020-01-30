package model.habit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HabitPrinter {
    private Map<Category, HabitList> habitCategories = new HashMap<>();
    ArrayList<Category> categories;

    // EFFECTS: prints habits in habit list of a certain category
    public String printHabits(String string) {
        System.out.println("This category has these habits:");
        Category thisCategory = new Category("new");
        for (Category c : categories) {
            if (c.categoryName == string) {
                thisCategory = c;
            }
            HabitList listOfHabits = habitCategories.get(thisCategory);
            listOfHabits.print();
        }
        return "Habits printed!";
    }


    // EFFECTS: prints all habits from all categories
    public String printAll() {
        return String.valueOf(habitCategories.keySet());
    }


}

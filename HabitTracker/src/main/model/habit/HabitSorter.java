package model.habit;

import network.ReadWebPage;

import java.io.*;
import java.util.*;

public class HabitSorter implements Saveable, Loadable {
    private Map<Category, HabitList> habitCategories = new HashMap<>();
    //    ArrayList<Category> categories;
    HabitRecommender habitRecommender = new HabitRecommender();
    HabitPrinter habitPrinter = new HabitPrinter();
//    HabitList uncheckedList = new HabitList();

    public HabitSorter() {
        habitCategories = new HashMap<>();
    }


    public void addHabitRelation(Category category) {
        if (!habitCategories.containsKey(category)) {
            habitCategories.put(category, new HabitList());
        }
//        categories.add(category);
//        habitCategories.put(habit, new ArrayList<Category>());
    }

    public void addHabitRelation(Category category, Habit habit) {
        HabitList listOfHabits = habitCategories.get(category);
//        ArrayList<Category> listOfHabits = habitCategories.get(habit);
        listOfHabits.addHabit(habit);
        habit.setKey(category);
    }

    // EFFECTS: saves text to file
    public void save() throws IOException {
        try {
            FileOutputStream fileOutStr =
                    new FileOutputStream("habitSorterOutput");
            ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
            objOutStr.writeObject(habitCategories);
            // Close all streams
            objOutStr.close();
            fileOutStr.close();
            System.out.printf("Habits & categories saved - habitSorterOutput.");
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }


    // EFFECTS: loads saved file from previously
    public HabitList load(FileInputStream habitSorterFile) throws IOException, ClassNotFoundException {
        HabitList newSet = new HabitList();
        try {
            habitSorterFile = new FileInputStream("habitSorterOutput");
            ObjectInputStream objInStr = new ObjectInputStream(habitSorterFile);
            habitCategories = (Map<Category, HabitList>) objInStr.readObject();
            objInStr.close();
            habitSorterFile.close();
        } catch (IOException exp) {
            exp.printStackTrace();
            return newSet;
        } catch (ClassNotFoundException cexp) {
            System.out.println("Habit list not found");
            cexp.printStackTrace();
            return newSet;
        }
//        print();
        return newSet;
    }

    // EFFECTS: returns true if category is in habitCategories
    public boolean containsKey(Category category) {
        return habitCategories.containsKey(category);
    }

    // EFFECTS: prints habits in the set
    public void printHabits(String string) {
        Category thisCategory = new Category("c");
        String returnThis = "";
        for (Category c : habitCategories.keySet()) {
            if (c.categoryName == string) {
                thisCategory = c;
            }
            System.out.println("This category has these habits: " + (habitCategories.get(thisCategory)));

        }
    }


//    public List<Habit> getHabits(String string) {
//        Category thisCategory = new Category("c");
//        List returnList = new ArrayList<Habit>();
//        for (Category c : habitCategories.keySet()) {
//            if (c.categoryName == string) {
//                thisCategory = c;
//                returnList.add(thisCategory);
//            }
//        }
//        return returnList;
//    }
//        habitPrinter.printHabits(string);

    // EFFECTS: prints all habits
    public void printAll() {
//        System.out.println(habitCategories.keySet());
        habitPrinter.printAll();
    }

    // EFFECTS: return habits in the same cateogory as habit
    public void suggestRelatedHabits(Habit habit) {
        habitRecommender.suggestHabits(habit);
    }

    // EFFECTS: get Set of categories in the key set
    public Set<Category> getCategories() {
        return habitCategories.keySet();
    }

    // EFFECTS: return just the Map of Category and HabitList
    public Map<Category, HabitList> getMap() {
        return habitCategories;
    }
//
//    public HabitList HabitList() {
//        return habitList;
//    }


}

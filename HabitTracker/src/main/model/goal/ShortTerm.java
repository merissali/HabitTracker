//package model.goal;
//
//import model.Category;
//import model.model.AbstractList;
//import model.model.CheckedList;
//
//import java.util.ArrayList;
//
//public class ShortTerm implements Goal {
//    private ShortTerm shortTerm = new ShortTerm();
//    private String goal;
//    Category category;
//    LongTerm longTermGoal;
//    ArrayList<String> shortTermGoalHabits;
//    AbstractList habits;
//
//
//    public void edit(String editedGoal) {
//        goal = editedGoal;
//        System.out.println("Your short term goal has been changed from"
//                + goal + " to " + editedGoal);
//    }
//
//    // EFFECTS: prints list of daily habits for this ShortTerm
//    public void printAll() {
//        for (String model : shortTermGoalHabits) {
//            System.out.println(model);
//            System.out.println("\n");
//        }
//    }
//
//
//    // EFFECTS: gets & prints string name of goal
//    public String getShortTermName() {
//        return goal;
//    }
//
//    // EFFECTS: check if model list of ShortTerm contains a given model
//    public boolean contains(String searchHabit) {
//        if (shortTermGoalHabits.contains(searchHabit)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    // EFFECTS: checks size of model list
//    public int size() {
//        return shortTermGoalHabits.size();
//    }
//
//
//    // REQUIRES: non empty list
//    // MODIFIES: this
//    //  EFFECTS: removes model from list
//    public void removeHabit(String completedHabit) {
//        CheckedList doneHabits = new CheckedList();
//        for (String model : shortTermGoalHabits) {
//            if (model.equals(completedHabit)) {
//                habits.removeHabit(model);
//                doneHabits.addHabit(model);
//            }
//        }
//        habits.removeHabit(completedHabit);
//        doneHabits.addHabit(completedHabit);
//    }
//}
//
//
//

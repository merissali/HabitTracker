//package model.goal;
//
//import model.Category;
//
//import java.util.Scanner;
//
//import java.util.ArrayList;
//
//public class LongTerm implements Goal {
//    //    Scanner scanner = new Scanner(System.in);
////    Category category;
//    private ArrayList<ShortTerm> shortTermGoals;
//    private String goal;
//
//    // MODIFIES: this
//    // EFFECTS: changes goal of LongTerm
//    public void edit(String editedGoal) {
//        goal = editedGoal;
//        System.out.println("Your long term goal has been changed from"
//                + goal + " to " + editedGoal);
//    }
//
//    // MODIFIES: ArrayList<ShortTerm>
//    // EFFECTS: adds to list of short term goals
//    public void addHabit(ShortTerm newGoal) {
//        shortTermGoals.addHabit(newGoal);
//        System.out.println("You have added"
//                + newGoal + " as a short term goal");
//    }
//
//
//    // EFFECTS: gets & prints string name of goal
//    public String getLongTermName() {
//        return goal;
//    }
//
//    // EFFECTS; prints list of short term goals
//    public void printShortTerm() {
//        for (ShortTerm shortTerm : shortTermGoals) {
//            System.out.println(shortTerm.getShortTermName());
//            System.out.println("\n");
//        }
//
//    }
//}

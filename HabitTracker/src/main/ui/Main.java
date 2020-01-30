package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

import model.habit.*;
import network.ReadWebPage;

public class Main {
    Scanner input = new Scanner(System.in);
    ReadWebPage readWebPage = new ReadWebPage();
    HabitList mySet = new HabitList();
    FileOutputStream outputFile = new FileOutputStream("habitListOutput.txt");
    FileInputStream inputFile = new FileInputStream("habitListOutput.txt");
    FileOutputStream habitSorterOutput = new FileOutputStream("habitSorterOutput.txt");
    FileInputStream habitSorterInput = new FileInputStream("habitSorterOutput.txt");
    HabitSorter habitSorter = new HabitSorter();
//    ReadWebPage webPage = new ReadWebPage();

    public Main() throws Exception {
        System.out.println("Welcome to your habit tracker!");
        while (true) {
            System.out.println("\nWhat would you like to do?"
                    + "\n1) Add a category and habit."
                    + "\n2) View all habits in a certain category."
                    + "\n3) Check off a habit."
                    + "\n4) View today's daily habits."
                    + "\n5) Load previous habit list."
                    + "\n6) View habits related to a certain habit."
                    + "\n7) New day? Reset list."
                    + "\n8) Exit.");

            String numberInput = input.nextLine();
            // add a category and a habit
            if (numberInput.equals("1")) {
                System.out.println("Please enter new category name.");
                Category newCategory = new Category(input.nextLine());
                habitSorter.addHabitRelation(newCategory);

                System.out.println("Please enter new habit.");
                Habit newHabit = new Habit(input.nextLine(), readWebPage);
                habitSorter.addHabitRelation(newCategory, newHabit);
                mySet.addHabit(newHabit);
                mySet.save();
                habitSorter.save();


                // view all habits in a certain category
            } else if (numberInput.equals("2")) {
                System.out.println("Enter category that you'd like to check for");
                habitSorter.printHabits(input.nextLine());

            } else if (numberInput.equals("3")) {
                System.out.println("Please enter habit to check off");
//                Habit completedHabit = new Habit(input.nextLine(), readWebPage);
//                mySet.markHabitDone(input.nextLine());
                mySet.searchForHabit(input.nextLine()).markDone();
                mySet.save();
                habitSorter.save();

            } else if (numberInput.equals("4")) {
                System.out.println("You have " + mySet.countUndone() + " habit(s) left to complete today:\n"
                        + mySet.print());

            } else if (numberInput.equals("5")) {
                mySet.load(inputFile);
                habitSorter.load(habitSorterInput);

            } else if (numberInput.equals("6")) {
                System.out.println("Please enter the habit for which you'd like to see its related habits.");
                String searchHabitName = input.nextLine();
                Habit suggestBasedOnHabit = mySet.searchForHabit(searchHabitName);
                habitSorter.suggestRelatedHabits(suggestBasedOnHabit);

            } else if (numberInput.equals("7")) {
                mySet.reset();

            } else if (numberInput.equals("8")) {
                System.exit(0);

            } else {
                System.out.println("Please choose an option");
            }
        }

    }


    @SuppressWarnings("checkstyle:Indentation")
    public static void main(String[] args) throws Exception {
//        HabitList newList = new HabitList();
//        Habit habit = new Habit("1");
//        Category personal = new Category("personal");
//        Category academic = new Category("academic");
//        newList.addHabit(habit);
//        HabitSorter habitSorter = new HabitSorter();
//        habitSorter.addHabitRelation(personal);
//        habitSorter.addHabitRelation(academic);
//        habitSorter.addHabitRelation(personal, habit);
//        habitSorter.addHabitRelation(academic, habit);
//        habitSorter.printAll();


        new Main();

//        habitSorter.printAll();


//        HabitList mySet = new HabitList();
//        mySet.save();
//        mySet.load();

    }
}




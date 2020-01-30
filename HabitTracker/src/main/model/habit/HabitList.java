package model.habit;

import model.exceptions.RemoveEmptyListException;
import model.exceptions.RemoveNotFoundException;
import network.ReadWebPage;
//import network.Subject;

import java.io.*;
import java.util.*;
import java.io.FileOutputStream;


public class HabitList implements Saveable, Loadable, Serializable {
    ArrayList<Habit> habits;
    List<Observer> observers;
    Observer observer;
    String habitListName;

    public HabitList() {
        habits = new ArrayList<Habit>();
        observers = new ArrayList<>();
        observer = new ReadWebPage();
        observers.add(observer);
    }

    public ArrayList<Habit> getArrayList() {
        return habits;
    }

    // EFFECTS: prints list of habits
    public String print() {
        String returnThis = "TEST";
        for (Habit h : habits) {
            returnThis += h.getName() + "\n";
        }
        return returnThis;
    }

    // EFFECTS: saves text to file
    public void save() throws IOException {
        try {
            FileOutputStream fileOutStr =
                    new FileOutputStream("habitListOutput.txt");
            ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
            objOutStr.writeObject(habits);
            // Close all streams
            objOutStr.close();
            fileOutStr.close();
            System.out.printf("Habits saved - habitListOutput.");
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }


    // EFFECTS: loads saved file from previously
    public HabitList load(FileInputStream fileInStr) throws IOException, ClassNotFoundException {
        HabitList newSet = new HabitList();
        try {
            fileInStr = new FileInputStream("habitListOutput.txt");
            ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
            habits = (ArrayList<Habit>) objInStr.readObject();
            objInStr.close();
            fileInStr.close();
        } catch (IOException exp) {
            exp.printStackTrace();
            return newSet;
        } catch (ClassNotFoundException cexp) {
            System.out.println("Habit list not found");
            cexp.printStackTrace();
            return newSet;
        }
        print();
        return newSet;
    }

    // REQUIRES: list to have >= i elements
    // EFFECTS: returns element at index i
    public Habit getHabit(int i) {
        if (i < habits.size()) {
            return (habits.get(i));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    // MODIFIES: this
    // EFFECTS: removes given model from the list, if found
    public void removeHabit(Habit thisHabit)
            throws RemoveNotFoundException, RemoveEmptyListException {
        if (habitIsInHabitList(thisHabit)) {
            habits.remove(thisHabit);
        } else if (habitListIsEmpty()) {
            throw new RemoveEmptyListException();
        } else {
            throw new RemoveNotFoundException();
        }
    }

    // EFFECTS: returns true if habit is in the list
    protected boolean habitIsInHabitList(Habit thisHabit) {
        return habits.contains(thisHabit);
    }

    // EFFECTS: returns true if habit list is empty
    protected boolean habitListIsEmpty() {
        return habits.size() == 0;
    }

//
//    // EFFECTS: returns just the names of the habits
//    public String getJustHabitNames() {
//        String returnThis = "";
//        for (Habit h : habits) {
//            returnThis += h.getName() + "\n";
//        }
//        return returnThis;
//    }

//    // EFFECTS: returns name of habit list
//    public String getName() {
//        return this.habitListName;
//    }


    // MODIFIES: this
    // EFFECTS: adds habit to list
    public void addHabit(Habit habit) {
        if (!habitIsInHabitList(habit)) {
            habits.add(habit);
        }
    }

    // EFFECTS: returns true if checkHabit is in habits, false otherwise
    public boolean contains(Habit checkHabit) {
        return habitIsInHabitList(checkHabit);
    }

    // MODIFIES: habit with habit name s
    // EFFECTS: marks habit as done
    public void markHabitDone(String s) {
        for (Habit habit : habits) {
            if (habit.getName() == s) {
                habit.markDone();
            }
        }
    }

    // EFFECTS: returns size of habit list
    public int size() {
        return habits.size();
    }

    // EFFECTS: returns habit based on habit name
    public Habit searchForHabit(String s) {
        Habit returnHabit = new Habit("new", observer);
        for (Habit h : habits) {
            if (h.getName() == s) {
                returnHabit = h;
            }
        }
        return returnHabit;
    }

    // EFFECTS: returns number of undone habits in list
    public int countUndone() {
        return size() - countDone();
//        int undoneCount = 0;
//        for (Habit h : habits) {
//            if (!h.done) {
//                undoneCount++;
//            }
//        }
//        return undoneCount;
    }

    // EFFECTS: returns number of done habits in list
    public int countDone() {
        int doneCount = 0;
        for (Habit h : habits) {
            if (h.done) {
                doneCount++;
            }
        }
        return doneCount;
    }

    // MODIFIES: this
    // EFFECTS: sets all habits to undone; reset
    public void reset() {
        for (Habit h : habits) {
            h.markUndone();
        }
    }
}
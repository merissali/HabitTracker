package model.habit;

import java.io.Serializable;
import java.util.*;

public class Habit extends Observable implements Serializable {
    String habitName;
    public Category key;
    Boolean done;
    List<Observer> observers;

    // constructor
    public Habit(String name, Observer observer) {
        habitName = name;
        done = false;
        observers = new ArrayList<>();
        observers.add(observer);
//        habitType = type;
    }


    // MODIFIES: this
    // EFFECTS: changes the category that the habit is in
    public void setKey(Category category) {
        this.key = category;
    }

    // EFFECTS: returns true if habit is marked as done; false otherwise
    public boolean getDone() {
        return done;
    }

    // EFFECTS: returns true if object of comparison is equal to Object o
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Habit habit = (Habit) o;
        return habitName.equals(habit.habitName);
    }


    @Override
    public int hashCode() {
        return Objects.hash(habitName);
    }
//        u.addHabit(this);
//    }

//    public void setName(String s) {
//        this.habitName = s;
//    }

    public String getName() {
        return habitName;
    }

    // MODIFIES: this
    // EFFECTS: marks habit as done
    public void markDone() {
        this.done = true;
        setChanged();
        notifyObservers();
    }


    // MODIFIES: this
    // EFFECTS: marks habit as not done
    public void markUndone() {
        this.done = false;
    }


}

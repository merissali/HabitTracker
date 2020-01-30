package model;

import model.habit.*;
import network.ReadWebPage;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HabitSorterTest {
    HabitSorter habitSorter = new HabitSorter();
    ReadWebPage testWebPage = new ReadWebPage();


    Category personal = new Category("personal");
    Habit habit1 = new Habit("test", testWebPage);
    Habit habit2 = new Habit("test1", testWebPage);

    @Test
    public void testInitial() {
        assertEquals(0, habitSorter.getCategories().size());
//        assertEquals(0, habitSorter.getHabitList().size());
    }

    @Test
    public void testAddHabitRelationNew() {
        habitSorter.addHabitRelation(personal);
        assertTrue(habitSorter.containsKey(personal));
    }

    @Test
    public void testAddHabitRelationAlreadyIn() {
        habitSorter.addHabitRelation(personal);
        assertTrue(habitSorter.containsKey(personal));
        habitSorter.addHabitRelation(personal);
        assertEquals(1, habitSorter.getCategories().size());
    }

    @Test
    public void addHabitRelationAddHabit() {
        habitSorter.addHabitRelation(personal);
        assertTrue(habitSorter.containsKey(personal));
        habitSorter.addHabitRelation(personal, habit1);
        HabitList testList = new HabitList();
        testList.addHabit(habit1);
        assertEquals(testList, habitSorter.getMap().get(personal));
    }

//    @Test
//    public void testPrintHabitsOneHabit() {
//        habitSorter.addHabitRelation(personal);
//        habitSorter.addHabitRelation(personal, habit1);
//        assertEquals("This category has these habits: test", habitSorter.printHabits("personal"));
//    }
//
//    @Test
//    public void testPrintHabitsNoHabits() {
//        habitSorter.addHabitRelation(personal);
//        assertEquals("This category has these habits: ", habitSorter.printHabits("personal"));
//    }
//
//    @Test
//    public void testPrintHabitsTwoHabits() {
//        habitSorter.addHabitRelation(personal);
//        habitSorter.addHabitRelation(personal, habit1);
//        habitSorter.addHabitRelation(personal, habit2);
//        assertEquals("This category has these habits: test\ntest1\n", habitSorter.printHabits("personal"));
//    }
}
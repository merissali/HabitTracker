//package model;
//
//import model.exceptions.RemoveEmptyListException;
//import model.exceptions.RemoveNotFoundException;
//import model.habit.Habit;
//import model.habit.HabitList;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public abstract class AbstractListTest {
//
//    ArrayList<Habit> habits = new ArrayList<Habit>();
//    private Habit habit1 = new Habit("habit1");
//    private Habit habit2 = new Habit("Habit2");
//
//    @Test
//    public void testSizeEmpty() {
//        assertEquals(0, habits.size());
//    }
//
//    @Test
//    public void testSizeOne() {
//        habits.add(habit1);
//        assertEquals(1, habits.size());
//    }
//
//    @Test
//    public void testRemoveHabitRegular() {
//        habits.add(habit1);
//        assertTrue(habits.contains(habit1));
//        habits.remove(habit1);
//        assertFalse(habits.contains(habit1));
//    }
//
//    @Test
//    public void testRemoveHabitEmptyUnchecked() {
//        HabitList habitList = new HabitList();
//        assertEquals(0, habitList.size());
//        try {
//            habitList.removeHabit(habit1);
//            fail("Exception not thrown");
//        } catch (RemoveEmptyListException e) {
//        } catch (RemoveNotFoundException e) {
//            fail("Should have thrown other exception.");
//        }
//    }
//
//    @Test
//    public void testRemoveHabitNotFoundUnchecked() {
//        HabitList habitList = new HabitList();
//        habitList.addHabit(habit1);
//        assertEquals(1, habitList.size());
//        try {
//            habitList.removeHabit(habit2);
//            fail("Exception not thrown");
//        } catch (RemoveNotFoundException e) {
//        } catch (RemoveEmptyListException e) {
//            fail("Should have thrown other exception.");
//
//        }
//    }
//
//
//    @Test
//    public void testAddHabit() {
//        assertEquals(0, habits.size());
//        habits.add(habit1);
//        assertEquals(1, habits.size());
//    }
//
//    @Test
//    public void testContainsTrue() {
//        habits.add(habit1);
//        assertEquals(1, habits.size()); // true case, one case
//        assertTrue(habits.contains(habit1));
//    }
//
//    @Test
//    public void testContainsFalse() {
//        habits.add(habit1);
//        assertFalse(habits.contains(habit2));
//    }
//
//    @Test
//    public void testGetSuccessful() {
//        habits.add(habit1);
//        assertEquals(habit1, habits.get(0));
//        habits.add(habit2);
//        assertEquals(habit2, habits.get(1));
//    }
//
//    @Test
//    public void testGetEmpty() {
//        try {
//            habits.get(0);
//            fail("Exception not thrown");
//        } catch (IndexOutOfBoundsException i) {
//        }
//    }
//
//}
//

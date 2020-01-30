package model;

import model.exceptions.RemoveEmptyListException;
import model.exceptions.RemoveNotFoundException;
import model.habit.Habit;
import model.habit.HabitList;
import network.ReadWebPage;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertTrue;


public class HabitListTest {
    ReadWebPage testWebPage = new ReadWebPage();
    HabitList testHabits = new HabitList();
    Habit testNewHabit = new Habit("test", testWebPage);
    Habit testNewHabit1 = new Habit("test1", testWebPage);
//    FileInputStream testFileIn = new FileInputStream("testoutfile.txt");

    @Test
    public void testInitial() {
        assertEquals(0, testHabits.size());
    }

    @Test
    public void testGetArrayList() {
        testHabits.addHabit(testNewHabit);
        HabitList testList = new HabitList();
        testList.addHabit(testNewHabit);
        assertEquals(testList.getArrayList(), testHabits.getArrayList());
    }

    @Test
    public void testPrintEmpty() {
        assertEquals(0, testHabits.size());
        testHabits.print();
        assertEquals("", testHabits.print());
    }

    @Test
    public void testPrintOne() {
        assertEquals(0, testHabits.size());
        testHabits.addHabit(testNewHabit);
        testHabits.print();
        assertEquals("test\n", testHabits.print());
    }

    @Test
    public void testPrintSeveral() {
        testHabits.addHabit(testNewHabit);
        testHabits.addHabit(testNewHabit1);
        testHabits.print();
        assertEquals("test\ntest1\n", testHabits.print());
    }


    @Test
    public void testRemoveOnEmptyList() {
        assertEquals(0, testHabits.size());
        try {
            testHabits.removeHabit(testNewHabit);
            fail("Exception expected");
        } catch (RemoveEmptyListException e) {
            e.printStackTrace();
        } catch (RemoveNotFoundException e) {
            fail("Exception not expected");
            e.printStackTrace();
        }
        assertEquals(0, testHabits.size());
    }

    @Test
    public void testRemoveRegular() {
        assertEquals(0, testHabits.size());
        testHabits.addHabit(testNewHabit);
        assertEquals(1, testHabits.size());
        try {
            testHabits.removeHabit(testNewHabit);
        } catch (RemoveNotFoundException e) {
            fail("Exception not expected");
            e.printStackTrace();
        } catch (RemoveEmptyListException e) {
            fail("Exception not expected");
            e.printStackTrace();
        }
        assertEquals(0, testHabits.size());
    }


    @Test
    public void testRemoveNotFound() {
        Habit notInThere = new Habit("notThere", testWebPage);
        testHabits.addHabit(testNewHabit);
        assertEquals(1, testHabits.size());
        try {
            testHabits.removeHabit(notInThere);
            fail("Exception not thrown");
        } catch (RemoveNotFoundException e) {
            System.out.println("Habit not found in list!");
            e.printStackTrace();
        } catch (RemoveEmptyListException e) {
            System.out.println("This exception not expected");
            e.printStackTrace();
        }
        assertEquals(1, testHabits.size());
    }

    @Test
    public void testSave() {
        FileInputStream testFileIn = null;
        try {
            testFileIn = new FileInputStream("testoutfile.txt");
        } catch (FileNotFoundException e) {
        }
        HabitList testSet = new HabitList();
        testSet.addHabit(testNewHabit);
        testSet.addHabit(testNewHabit1);
        assertEquals("test", testSet.getHabit(0).getName());
        assertEquals("test1", testSet.getHabit(1).getName());
        try {
            testSet.save();
        } catch (IOException e) {
            fail("Exception not expected.");
        }
        assertEquals("test", testSet.getHabit(0).getName());
        assertEquals("test1", testSet.getHabit(1).getName());
        try {
            testSet.load(testFileIn);
        } catch (Exception e) {
            fail("Exception not expected");
            e.printStackTrace();
        }
        assertEquals("test", testSet.getHabit(0).getName());
        assertEquals("test1", testSet.getHabit(1).getName());
    }

    @Test
    public void testLoadRegular() {
        FileInputStream testFileIn = null;
        try {
            testFileIn = new FileInputStream("testoutfile.txt");
        } catch (FileNotFoundException e) {
        }
        HabitList testSet = new HabitList();
        testSet.addHabit(testNewHabit);
        testSet.addHabit(testNewHabit1);
        try {
            testSet.save();
        } catch (IOException e) {
            fail("Exception not expected.");
        }
        try {
            testSet.load(testFileIn);
        } catch (Exception e) {
            fail("Didn't load properly!");
            e.printStackTrace();
        }
        assertEquals("test", testSet.getHabit(0).getName());
        assertEquals("test1", testSet.getHabit(1).getName());
        assertEquals(2, testSet.size());
    }

    @Test
    public void testLoadClassNotFound() {
        try {
            FileInputStream testFileInStr = new FileInputStream("inputfile.txt");
            testHabits.load(testFileInStr);
            fail("Exception expected");
        } catch (Exception e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }
    }

    @Test
    public void testGetHabitNotInList() {
        testHabits.addHabit(testNewHabit);
        assertEquals(1, testHabits.size());
        try {
            testHabits.getHabit(1);
            fail("Exception should have been thrown");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void testGetHabitEmptyList() {
        assertEquals(0, testHabits.size());
        try {
            testHabits.getHabit(1);
            fail("Exception should have been thrown");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test
    public void testGetHabitRegular() {
        testHabits.addHabit(testNewHabit);
        testHabits.getHabit(0);
    }

//    @Test
//    public void testGetName() {
//        assertEquals("test", testHabits.getName());
//    }


    @Test
    public void testAddHabitNew() {
        assertFalse(testHabits.contains(testNewHabit));
        testHabits.addHabit(testNewHabit);
        assertTrue(testHabits.contains(testNewHabit));
    }

    @Test
    public void testAddHabitAlreadyExists() {
        testHabits.addHabit(testNewHabit);
        assertTrue(testHabits.contains(testNewHabit));
        assertEquals(1, testHabits.size());
        testHabits.addHabit(testNewHabit);
        assertEquals(1, testHabits.size());
    }

    @Test
    public void testContainsTrue() {
        testHabits.addHabit(testNewHabit);
        assertTrue(testHabits.contains(testNewHabit));
    }

    @Test
    public void testContainsEmpty() {
        assertEquals(0, testHabits.size());
        assertFalse(testHabits.contains(testNewHabit));
    }

    @Test
    public void testContainsFalse() {
        testHabits.addHabit(testNewHabit1);
        assertFalse(testHabits.contains(testNewHabit));
    }

    @Test
    public void testMarkHabitDoneRegularOne() {
        testHabits.addHabit(testNewHabit);
        assertTrue(testHabits.contains(testNewHabit));
        assertFalse(testNewHabit.getDone());
        testHabits.markHabitDone("test");
        assertTrue(testNewHabit.getDone());
    }

    @Test
    public void testMarkHabitDoneRegularTwo() {
        testHabits.addHabit(testNewHabit);
        testHabits.addHabit(testNewHabit1);
        assertEquals(2, testHabits.size());
        assertFalse(testNewHabit.getDone());
        assertFalse(testNewHabit1.getDone());
        testHabits.markHabitDone("test");
        testHabits.markHabitDone("test1");
        assertEquals(2, testHabits.size());
        assertTrue(testNewHabit.getDone());
        assertTrue(testNewHabit1.getDone());
    }

    @Test
    public void testMarkHabitDoneNotFound() {
        testHabits.addHabit(testNewHabit);
        assertEquals(1, testHabits.size());
        testHabits.markHabitDone("test1");
        assertEquals(1, testHabits.size());
    }

    @Test
    public void testMarkHabitDoneEmpty() {
        assertEquals(0, testHabits.size());
        testHabits.markHabitDone("test");
        assertEquals(0, testHabits.size());
    }

    @Test
    public void testSearchForHabitFoundOne() {
        testHabits.addHabit(testNewHabit);
        assertEquals(testNewHabit, testHabits.searchForHabit("test"));
    }

    @Test
    public void testCountUndoneEmpty() {
        assertEquals(0, testHabits.countUndone());
    }

    @Test
    public void testCountUndoneZero() {
        testHabits.addHabit(testNewHabit);
        testHabits.markHabitDone("test");
        assertEquals(0, testHabits.countUndone());
    }

    @Test
    public void testCountUndoneOne() {
        testHabits.addHabit(testNewHabit);
        assertEquals(1, testHabits.countUndone());
    }

    @Test
    public void testCountDoneEmpty() {
        assertEquals(0, testHabits.countDone());
    }

    @Test
    public void testCountDoneZero() {
        testHabits.addHabit(testNewHabit);
        assertEquals(0, testHabits.countDone());
    }

    @Test
    public void testCountDoneOne() {
        testHabits.addHabit(testNewHabit);
        testHabits.markHabitDone("test");
        assertEquals(1, testHabits.countDone());
    }

    @Test
    public void testResetSuccessful() {
        testHabits.addHabit(testNewHabit);
        testHabits.markHabitDone("test");
        assertTrue(testNewHabit.getDone());
        assertEquals(0, testHabits.countUndone());
        testHabits.reset();
        assertFalse(testNewHabit.getDone());
        assertEquals(1, testHabits.countUndone());
    }

    @Test
    public void testResetNoneToReset() {
        testHabits.addHabit(testNewHabit);
        assertFalse((testNewHabit.getDone()));
        assertEquals(1, testHabits.countUndone());
        testHabits.reset();
        assertEquals(1, testHabits.countUndone());
    }
}

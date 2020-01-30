package model;

import model.habit.Category;
import model.habit.Habit;
import network.ReadWebPage;
import org.junit.jupiter.api.Test;

import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;


public class HabitTest {
    Observer testObserver;

    @Test
    public void testHabit() {
        String name;
        testObserver = new ReadWebPage();

    }

    @Test
    public void testGetName() {
        Habit h = new Habit("test", testObserver);
        assertEquals("test", h.getName());
    }

    @Test
    public void testEqualsEquals() {
        Category c = new Category("c");
        Category b = c;
        assertTrue(b.equals(c));
        assertTrue(c.equals(b));
    }

    @Test
    public void testEqualsNull() {
        Category c = new Category("c");
        assertFalse(c.equals(null));
    }

//    @Test
//    public void testHashCode() {
//
//    }
}

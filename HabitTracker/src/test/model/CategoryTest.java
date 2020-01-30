package model;

import model.habit.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
    Category c = new Category("c");

    @Test
    public void testConstructor() {
        assertEquals("c", c.getName());
    }
}

package linked.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {
    private LinkedList list;

    @BeforeEach
    public void before() {
        list = new LinkedList();
    }

    @Test
    public void newList() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void listWithContentHasSize() {
        addFiveItems();
        assertFalse(list.isEmpty());
        assertEquals(5, list.size());
    }

    @Test
    public void singleItemCanBeRetrieved() {
        list.add("abc");
        assertEquals("abc", list.get(0));
    }

    private void addFiveItems() {
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
    }
}

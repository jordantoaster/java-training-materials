package linked.list.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList list;

    @BeforeEach
    public void start() throws Exception {
        list = new LinkedList();
    }

    @Test
    public void newListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void nonEmptyListHasSize() {
        addFiveItems();
        assertFalse(list.isEmpty());
        assertEquals(5, list.size());
    }

    @Test
    public void retrieveSingleItem() {
        addTestItems("abc");
        assertEquals("abc", list.get(0));
    }

    @Test
    public void retrieveMultipleItems() {
        addFiveItems();
        assertEquals("abc", list.get(0));
        assertEquals("def", list.get(1));
        assertEquals("ghi", list.get(2));
        assertEquals("jkl", list.get(3));
        assertEquals("mno", list.get(4));
    }

    private void addFiveItems() {
        String[] data = {"abc", "def", "ghi", "jkl", "mno"};
        addTestItems(data);
    }

    private void addTestItems(String... items) {
        for (String item : items) {
            list.add(item);
        }
    }
}

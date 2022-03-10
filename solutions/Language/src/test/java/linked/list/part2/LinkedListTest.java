package linked.list.part2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList list;

    @BeforeEach
    public void setUp() {
        list = new LinkedList();
    }

    @Test
    public void newListIsEmpty() {
        assertTrue(list.size() == 0);
    }

    @Test
    public void nonEmptyListHasSize() {
        addFiveItems();
        assertFalse(list.isEmpty());
        assertEquals(5, list.size());
    }

    @Test
    public void addingSingleItem() throws Exception {
        list.add("abc");
        assertEquals(1, list.size());
        assertEquals("abc", list.get(0));
    }

    @Test
    public void addingMultipleItems() throws Exception {
        addFiveItems();
        assertEquals(5, list.size());
        assertEquals("abc", list.get(0));
        assertEquals("def", list.get(1));
        assertEquals("ghi", list.get(2));
        assertEquals("jkl", list.get(3));
        assertEquals("mno", list.get(4));
    }

    @Test
    public void getThrowsOnInvalidIndex() throws Exception {
        assertThrows(
                ItemNotInListException.class,
                () -> {
                    addFiveItems();
                    list.get(100);
                }
        );

    }

    @Test
    public void getThrowsWhenListEmpty() throws Exception {
        assertThrows(
                ListEmptyException.class,
                () -> list.get(100)
        );
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

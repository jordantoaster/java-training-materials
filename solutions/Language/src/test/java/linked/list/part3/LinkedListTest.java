package linked.list.part3;

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
        checkContentAndLength("abc", "def", "ghi", "jkl", "mno");
    }

    @Test
    public void toStringWorks() {
        assertEquals("Empty list", list.toString());
        addFiveItems();
        String expected = "List holding: abc def ghi jkl mno";
        assertEquals(expected, list.toString());
    }

    @Test
    public void removingOnlyElement() throws Exception {
        addTestItems("abc");
        list.remove("abc");
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void removingFirstElement() throws Exception {
        addFiveItems();
        list.remove("abc");
        checkContentAndLength("def", "ghi", "jkl", "mno");
    }

    @Test
    public void removingLastElement() throws Exception {
        addFiveItems();
        list.remove("mno");
        checkContentAndLength("abc", "def", "ghi", "jkl");
    }

    @Test
    public void removingElementFromMiddle() throws Exception {
        addFiveItems();
        list.remove("ghi");
        checkContentAndLength("abc", "def", "jkl", "mno");
    }

    @Test
    public void clearingContents() {
        addFiveItems();
        list.clear();
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());
    }

    @Test
    public void removeThrowsOnEmptyList() throws Exception {
        assertThrows(
                ListEmptyException.class,
                () -> list.remove("def")
        );
    }

    @Test
    public void removeThrowsOnBadItemName() throws Exception {
        addFiveItems();
        assertThrows(
                ItemNotInListException.class,
                () -> list.remove("zzz")
        );
    }

    @Test
    public void getThrowsOnInvalidIndex() throws Exception {
        addFiveItems();
        assertThrows(
                ItemNotInListException.class,
                () -> list.get(100)
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

    private void checkContentAndLength(String... items) throws Exception {
        for (int i = 0; i < items.length; i++) {
            assertEquals(items[i], list.get(i));
        }
        assertEquals(items.length, list.size());
    }
}

package perfect.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static perfect.numbers.PerfectNumber.isPerfect;

public class PerfectNumberTest {
    @Test
    public void perfectNumbers() {
        assertTrue(isPerfect(6));
        assertTrue(isPerfect(28));
        assertTrue(isPerfect(496));
        assertTrue(isPerfect(8128));
        assertTrue(isPerfect(33550336));
    }
    @Test
    public void imperfectNumbers() {
        assertFalse(isPerfect(16));
        assertFalse(isPerfect(33));
        assertFalse(isPerfect(499));
        assertFalse(isPerfect(9128));
    }
}

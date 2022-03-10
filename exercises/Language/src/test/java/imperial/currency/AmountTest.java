package imperial.currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmountTest {
    private Amount amount;

    @BeforeEach
    public void start() {
        amount = new Amount();
    }

    @Test
    public void handlesZero() {
        assertEquals(amount.toString(), "May God bless you");
    }

    @Test
    public void handlesOnePenny() {
        amount.add(Unit.PENNY);
        assertEquals(amount.toString(), "1 penny");
    }
}

package poker.hands;


import org.junit.jupiter.api.Test;
import poker.hands.PokerHand;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static poker.hands.PokerHand.buildHand;

public class PokerHandTest {
    @Test
    public void CanRecognisePair() {
        PokerHand hand = buildHand("3C 2S 7D 8H 7S");
        assertEquals("Pair", hand.name());
    }

    @Test
    public void CanRecogniseThreeOfAKind() {
        PokerHand hand = buildHand("4C 2S 4D 8H 4S");
        assertEquals("Three Of A Kind", hand.name());
    }

    @Test
    public void CanRecogniseFourOfAKind() {
        PokerHand hand = buildHand("8C 2S 8D 8H 8S");
        assertEquals("Four Of A Kind", hand.name());
    }

    @Test
    public void CanRecogniseFlush() {
        PokerHand hand = buildHand("8C 2C 9C 3C AC");
        assertEquals("Flush", hand.name());
    }

    @Test
    public void CanRecogniseRoyalFlush() {
        PokerHand hand = buildHand("QC JC KC 10C AC");
        assertEquals("Royal Flush", hand.name());
    }

    @Test
    public void CanRecogniseStraightFlush() {
        PokerHand hand = buildHand("8C 10C 9C QC JC");
        assertEquals("Straight Flush", hand.name());
    }

    @Test
    public void CanRecogniseTwoPair() {
        PokerHand hand = buildHand("8C 8H 9C QD QH");
        assertEquals("Two Pair", hand.name());
    }

    @Test
    public void CanRecogniseFullHouse() {
        PokerHand hand = buildHand("8C 8H QC QD QH");
        assertEquals("Full House", hand.name());
    }

    @Test
    public void CanRecogniseStraight() {
        Function<String, String> handName = s -> buildHand(s).name();
        final String expected = "Straight";

        assertEquals(expected, handName.apply("2H 6C 3D 5S 4H"));
        assertEquals(expected, handName.apply("3H 4C 6D 5S 7H"));
        assertEquals(expected, handName.apply("4H 8C 7D 5S 6H"));
        assertEquals(expected, handName.apply("5H 8C 6D 7S 9H"));
        assertEquals(expected, handName.apply("6H 10C 8D 9S 7H"));
        assertEquals(expected, handName.apply("7H 8C 10D 9S JH"));
        assertEquals(expected, handName.apply("8H 10C 9D JS QH"));
        assertEquals(expected, handName.apply("9H 10C QD JS KH"));
    }
}

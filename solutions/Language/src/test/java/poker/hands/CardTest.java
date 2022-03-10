package poker.hands;

import org.junit.jupiter.api.Test;
import poker.hands.Card;
import poker.hands.Rank;
import poker.hands.Suit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static poker.hands.Card.buildCard;

public class CardTest {
    @Test
    public void ranksAreRecognised() {
        assertEquals(Rank.Two, buildCard("2H").getRank());
        assertEquals(Rank.Three, buildCard("3D").getRank());
        assertEquals(Rank.Four, buildCard("4S").getRank());
        assertEquals(Rank.Five, buildCard("5C").getRank());
        assertEquals(Rank.Six, buildCard("6H").getRank());
        assertEquals(Rank.Seven, buildCard("7D").getRank());
        assertEquals(Rank.Eight, buildCard("8S").getRank());
        assertEquals(Rank.Nine, buildCard("9C").getRank());
        assertEquals(Rank.Ten, buildCard("10H").getRank());
        assertEquals(Rank.Jack, buildCard("JD").getRank());
        assertEquals(Rank.Queen, buildCard("QS").getRank());
        assertEquals(Rank.King, buildCard("KC").getRank());
        assertEquals(Rank.Ace, buildCard("AH").getRank());
    }

    @Test
    public void suitsAreRecognisedForDigits() {
        Card sampleHeart = buildCard("8H");
        Card sampleDiamond = buildCard("7D");
        Card sampleSpade = buildCard("6S");
        Card sampleClub = buildCard("5C");

        assertEquals(Suit.Hearts, sampleHeart.getSuit());
        assertEquals(Suit.Diamonds, sampleDiamond.getSuit());
        assertEquals(Suit.Spades, sampleSpade.getSuit());
        assertEquals(Suit.Clubs, sampleClub.getSuit());
    }

    @Test
    public void suitsAreRecognisedForTenCards() {
        Card sampleHeart = buildCard("10H");
        Card sampleDiamond = buildCard("10D");
        Card sampleSpade = buildCard("10S");
        Card sampleClub = buildCard("10C");

        assertEquals(Suit.Hearts, sampleHeart.getSuit());
        assertEquals(Suit.Diamonds, sampleDiamond.getSuit());
        assertEquals(Suit.Spades, sampleSpade.getSuit());
        assertEquals(Suit.Clubs, sampleClub.getSuit());
    }

    @Test
    public void suitsAreRecognisedForHighCards() {
        Card sampleHeart = buildCard("JH");
        Card sampleDiamond = buildCard("QD");
        Card sampleSpade = buildCard("KS");
        Card sampleClub = buildCard("AC");

        assertEquals(Suit.Hearts, sampleHeart.getSuit());
        assertEquals(Suit.Diamonds, sampleDiamond.getSuit());
        assertEquals(Suit.Spades, sampleSpade.getSuit());
        assertEquals(Suit.Clubs, sampleClub.getSuit());
    }
}

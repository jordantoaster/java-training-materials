package poker.hands;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    @Test
    public void ranksAreRecognised() {
        assertEquals(Rank.Two, Card.buildCard("2H").getRank());
        assertEquals(Rank.Three, Card.buildCard("3D").getRank());
        assertEquals(Rank.Four, Card.buildCard("4S").getRank());
        assertEquals(Rank.Five, Card.buildCard("5C").getRank());
        assertEquals(Rank.Six, Card.buildCard("6H").getRank());
        assertEquals(Rank.Seven, Card.buildCard("7D").getRank());
        assertEquals(Rank.Eight, Card.buildCard("8S").getRank());
        assertEquals(Rank.Nine, Card.buildCard("9C").getRank());
        assertEquals(Rank.Ten, Card.buildCard("10H").getRank());
        assertEquals(Rank.Jack, Card.buildCard("JD").getRank());
        assertEquals(Rank.Queen, Card.buildCard("QS").getRank());
        assertEquals(Rank.King, Card.buildCard("KC").getRank());
        assertEquals(Rank.Ace, Card.buildCard("AH").getRank());
    }

    @Test
    public void suitsAreRecognisedForDigits() {
        Card sampleHeart = Card.buildCard("8H");
        Card sampleDiamond = Card.buildCard("7D");
        Card sampleSpade = Card.buildCard("6S");
        Card sampleClub = Card.buildCard("5C");

        assertEquals(Suit.Hearts, sampleHeart.getSuit());
        assertEquals(Suit.Diamonds, sampleDiamond.getSuit());
        assertEquals(Suit.Spades, sampleSpade.getSuit());
        assertEquals(Suit.Clubs, sampleClub.getSuit());
    }

    @Test
    public void suitsAreRecognisedForTenCards() {
        Card sampleHeart = Card.buildCard("10H");
        Card sampleDiamond = Card.buildCard("10D");
        Card sampleSpade = Card.buildCard("10S");
        Card sampleClub = Card.buildCard("10C");

        assertEquals(Suit.Hearts, sampleHeart.getSuit());
        assertEquals(Suit.Diamonds, sampleDiamond.getSuit());
        assertEquals(Suit.Spades, sampleSpade.getSuit());
        assertEquals(Suit.Clubs, sampleClub.getSuit());
    }

    @Test
    public void suitsAreRecognisedForHighCards() {
        Card sampleHeart = Card.buildCard("JH");
        Card sampleDiamond = Card.buildCard("QD");
        Card sampleSpade = Card.buildCard("KS");
        Card sampleClub = Card.buildCard("AC");

        assertEquals(Suit.Hearts, sampleHeart.getSuit());
        assertEquals(Suit.Diamonds, sampleDiamond.getSuit());
        assertEquals(Suit.Spades, sampleSpade.getSuit());
        assertEquals(Suit.Clubs, sampleClub.getSuit());
    }
}

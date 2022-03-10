package poker.hands;

public class Card {
    public static Card buildCard(String card) {
        boolean isTenCard = card.startsWith("10");
        Rank rank = isTenCard ? Rank.Ten : Rank.convert(card.substring(0, 1));
        Suit suit = Suit.convert(card.substring(isTenCard ? 2 : 1));
        return new Card(rank, suit);
    }

    private final Rank rank;
    private final Suit suit;

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s%s", rank, suit);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}

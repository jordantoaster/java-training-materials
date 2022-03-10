package poker.hands;

import java.util.Arrays;

public class PokerHand {
    public static PokerHand buildHand(String hand) {
        String[] words = hand.split("[ ]+");
        Card[] cards = Arrays.stream(words)
                .map(Card::buildCard)
                .toArray(Card[]::new);
        return new PokerHand(cards);
    }

    private final Card[] cards;
    private String name;

    private PokerHand(Card[] cards) {
        this.cards = cards;
    }

    public String name() {
        if (isRoyalFlush()) {
            return "Royal Flush";
        }
        if (isStraightFlush()) {
            return "Straight Flush";
        }
        if (isFlush()) {
            return "Flush";
        }
        if (isStraight()) {
            return "Straight";
        }
        if (isFourOfAKind()) {
            return "Four Of A Kind";
        }
        if (isFullHouse()) {
            return "Full House";
        }
        if (isThreeOfAKind()) {
            return "Three Of A Kind";
        }
        if (isTwoPair()) {
            return "Two Pair";
        }
        if (isPair()) {
            return "Pair";
        }
        return "Highest Card";
    }

    private boolean isPair() {
        return false;
    }

    private boolean isTwoPair() {
        return false;
    }

    private boolean isFullHouse() {
        return false;
    }

    private boolean isThreeOfAKind() {
        return false;
    }

    private boolean isFourOfAKind() {
        return false;
    }

    private boolean isFlush() {
        return false;
    }

    private boolean isRoyalFlush() {
        return false;
    }

    private boolean isStraightFlush() {
        return false;
    }

    private boolean isStraight() {
        return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Card card : cards) {
            builder.append(card);
            builder.append(" ");
        }
        builder.append("= ");
        builder.append(name());
        return builder.toString();
    }
}

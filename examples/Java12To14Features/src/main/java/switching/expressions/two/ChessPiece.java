package switching.expressions.two;

public enum ChessPiece {
    PAWN,
    ROOK,
    KNIGHT,
    BISHOP,
    QUEEN,
    KING;

    int worth() {
        return switch(this) {
            case PAWN -> 1;
            case KNIGHT, BISHOP -> 3;
            case ROOK -> 5;
            case QUEEN -> 9;
            case KING -> Integer.MAX_VALUE;
        };
    }
}

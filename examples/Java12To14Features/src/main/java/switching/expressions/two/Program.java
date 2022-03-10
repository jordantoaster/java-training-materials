package switching.expressions.two;

public class Program {
    public static void main(String[] args) {
        for(ChessPiece p: ChessPiece.values()) {
            System.out.println(p.worth());
        }
    }
}

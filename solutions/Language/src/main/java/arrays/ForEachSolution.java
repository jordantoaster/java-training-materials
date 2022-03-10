package arrays;

public class ForEachSolution {
    private static byte[][] compuCow = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 7, 8, 3, 4, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 3, 3, 3, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 6, 6, 6, 9, 0, 0, 0, 0, 4, 3, 3, 3, 3, 3, 3, 3, 4, 0, 0},
            {0, 0, 0, 0, 0, 5, 0, 0, 4, 0, 0, 4, 0, 0, 0, 6, 6, 6, 6, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 8, 0, 4, 0, 0, 4, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 8, 4, 3, 3, 3, 3, 3, 3, 3, 3, 4, 0, 0, 0, 0, 4, 0, 0, 0, 0, 4, 0, 0, 0}
    };

    public static void main(String[] args) {
        for (byte[] subArray : compuCow) {
            for (byte b : subArray) {
                switch (b) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("(");
                        break;
                    case 2:
                        System.out.print(")");
                        break;
                    case 3:
                        System.out.print("_");
                        break;
                    case 4:
                        System.out.print("|");
                        break;
                    case 5:
                        System.out.print("*");
                        break;
                    case 6:
                        System.out.print("-");
                        break;
                    case 7:
                        System.out.print("/");
                        break;
                    case 8:
                        System.out.print("\\");
                        break;
                    case 9:
                        System.out.print("@");
                        break;
                    case 10:
                        System.out.print("o");
                        break;
                }
            }
            System.out.println();
        }
    }
}

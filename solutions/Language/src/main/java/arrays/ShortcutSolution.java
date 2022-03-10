package arrays;

public class ShortcutSolution {
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
                System.out.print(mapByte(b));
            }
            System.out.println();
        }
    }

    private static String mapByte(byte input) {
        final String[] values = {" ", "(", ")", "_", "|", "*", "-", "/", "\\", "@", "o"};
        if (input < values.length) {
            return values[input];
        }
        return "?";
    }
}

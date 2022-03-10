package access;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void swap(Point input1, Point input2) {
        int tmpX = input1.x;
        int tmpY = input1.y;
        input1.x = input2.x;
        input1.y = input2.y;
        input2.x = tmpX;
        input2.y = tmpY;
    }

    @Override
    public String toString() {
        String msg = "x=%s, y=%s";
        return String.format(msg, x, y);
    }
}

package access;

public class Program {
    public static void main(String[] args) {
        Point first = new Point(12, 34);
        Point second = new Point(56, 78);

        System.out.println(first);
        System.out.println(second);

        Point.swap(first, second);

        System.out.println(first);
        System.out.println(second);
    }
}

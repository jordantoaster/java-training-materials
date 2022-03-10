package resources;

public class Program {
    public static void main(String[] args) {
        MyResource r = new MyResource();
        try (r) {
            r.action();
        }
    }
}

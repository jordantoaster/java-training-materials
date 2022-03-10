package resources;

public class MyResource implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Closing the resource");
    }

    public void action() {
        System.out.println("Using the resource");
    }
}

package exceptions;

public class TryWithResource {
    private static class MyResource implements AutoCloseable {
        private int value;

        void setValue(int newValue) {
            value = newValue;
        }

        @Override
        public void close() {
            System.out.println("Close method called");
            if (value > 10) {
                throw new IllegalStateException("Boom!");
            }
        }
    }

    public static void main(String[] args) {
        try (MyResource t = new MyResource()) {
            t.setValue(8);
        }
        try (MyResource t = new MyResource()) {
            t.setValue(12);
            throw new IndexOutOfBoundsException("Smash!");
        }
    }
}

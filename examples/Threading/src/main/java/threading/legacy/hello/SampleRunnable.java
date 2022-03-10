package threading.legacy.hello;

public class SampleRunnable implements Runnable {
    public void run() {
        while(i<100) {
            System.out.println(Thread.currentThread().getName() + " msg " + i);
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                System.out.println("ZZZ");
            }
            synchronized(this) {
                i++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " complete!");
    }
    private int i;
}

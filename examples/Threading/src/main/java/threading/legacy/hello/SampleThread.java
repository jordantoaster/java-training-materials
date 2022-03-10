package threading.legacy.hello;

public class SampleThread extends Thread {
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println(getName() + " msg " + i);
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                System.out.println("ZZZ");
            }
        }
    }
}


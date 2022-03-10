package threading.legacy.hello;

public class Program {
    public static void main(String[] args) {
        //Create two threads via subclassing
        Thread t1 = new SampleThread();
        Thread t2 = new SampleThread();
        //Create two threads out of a runnable
        Runnable r = new SampleRunnable();
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        //Name the threads
        t1.setName("Thread one");
        t2.setName("Thread two");
        t3.setName("Thread three");
        t4.setName("Thread four");
        //Start the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        //Join with threads
        try {
            while(t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive()) {
                System.out.println("Main still waiting");
                //block till a thread completes or a quarter second passes
                t1.join(250);
                t2.join(250); 
                t3.join(250);
                t4.join(250);
            }
        } catch(InterruptedException ex) {
            System.out.println("YYY");
        }
        //Main thread completes
        System.out.println("----- End of main -----");
    }
}


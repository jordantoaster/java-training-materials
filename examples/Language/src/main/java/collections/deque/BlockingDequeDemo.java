package collections.deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingDequeDemo {
    public static void main(String[] args) {
        BlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        PublisherThread t1 = new PublisherThread(deque);
        ConsumerThread t2 = new ConsumerThread(deque);
        t1.start();
        t2.start();
    }

    private static class PublisherThread extends Thread {
        public PublisherThread(BlockingDeque<String> deque) {
            super();
            this.deque = deque;
        }

        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(4000);
                    deque.putFirst("Message: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Publisher done");
        }

        private BlockingDeque<String> deque;
    }

    private static class ConsumerThread extends Thread {
        public ConsumerThread(BlockingDeque<String> deque) {
            super();
            this.deque = deque;
        }

        public void run() {
            int count = 0;
            while (count < 20) {
                try {
                    String retval = deque.pollLast(2, TimeUnit.SECONDS);
                    if (retval == null) {
                        System.out.println("Consumer thread timed out trying to read value...");
                    } else {
                        System.out.println("Consumer thread read: " + retval);
                        count++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consumer done");
        }

        private BlockingDeque<String> deque;
    }
}

package threading.fork.join;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Program {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        long result = pool.invoke(new FileCountTask(new File("./src")));
        System.out.println("Total length of all files is: " + result);
    }
}

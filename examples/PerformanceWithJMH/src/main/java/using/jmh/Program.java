package using.jmh;

import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class Program {
    public static void main(String[] args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(".*")
                .warmupIterations(5)
                .measurementIterations(10)
                .jvmArgs("-server")
                .forks(1)
                .timeUnit(TimeUnit.SECONDS)
                .build();

        Collection<RunResult> records = new Runner(opts).run();
        System.out.println("\n\n");
        for (RunResult result : records) {
            Result r = result.getPrimaryResult();
            System.out.printf("(%s): %f %s over %d iterations\n",
                    r.getLabel(),
                    r.getScore(),
                    r.getScoreUnit(),
                    r.getStatistics().getN());
        }
    }
}

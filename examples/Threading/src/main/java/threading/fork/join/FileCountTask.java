package threading.fork.join;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

class FileCountTask extends RecursiveTask<Long> {
    private final File dirPath;

    FileCountTask(File dirPath) {
        this.dirPath = dirPath;
    }

    @Override
    protected Long compute() {
        printMsg();
        Optional<Map<Boolean, List<File>>> opt = partitionContents();
        return opt.map(this::processContents)
                .orElse(0L);
    }

    private void printMsg() {
        long threadId = Thread.currentThread().getId();
        String name = dirPath.getName();
        System.out.printf("Processing %s on thread %d\n", name, threadId);
    }

    private long processContents(Map<Boolean, List<File>> contents) {
        List<File> childDirs = contents.get(true);
        List<File> childFiles = contents.get(false);

        List<FileCountTask> childTasks = createAndInvokeChildTasks(childDirs);
        return totalLengthOfFiles(childFiles) + outputOfSubTasks(childTasks);
    }

    private List<FileCountTask> createAndInvokeChildTasks(List<File> result) {
        List<FileCountTask> childTasks = createChildTasks(result);
        ForkJoinTask.invokeAll(childTasks);
        return childTasks;
    }

    private Optional<Map<Boolean, List<File>>> partitionContents() {
        File[] contents = dirPath.listFiles();
        if (contents == null) {
            return Optional.empty();
        }
        return Optional.of(Arrays
                .stream(contents)
                .collect(partitioningBy(File::isDirectory)));
    }

    private List<FileCountTask> createChildTasks(List<File> directories) {
        return directories
                .stream()
                .map(FileCountTask::new)
                .collect(toList());
    }

    private long outputOfSubTasks(List<FileCountTask> childTasks) {
        return childTasks
                .stream()
                .mapToLong(FileCountTask::join)
                .sum();
    }

    private long totalLengthOfFiles(List<File> files) {
        return files
                .stream()
                .mapToLong(File::length)
                .sum();
    }
}

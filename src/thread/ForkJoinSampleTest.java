package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinSampleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processor" + numberOfProcessors);
        ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
        CustomRecursiveTask task1 = new CustomRecursiveTask("C:/Atul", ".pdf");
        CustomRecursiveTask task2 = new CustomRecursiveTask("C:/Atul", ".doc");
        CustomRecursiveTask task3 = new CustomRecursiveTask("C:/Atul", ".txt");

        pool.execute(task1);
        pool.execute(task2);
        pool.execute(task3);
        do {
            System.out.println("****************************************************");
            System.out.println("Parallelism   " + pool.getParallelism());
            System.out.println("Active Threads" + pool.getActiveThreadCount());
            System.out.println("Queued Task   " + pool.getQueuedTaskCount());
            System.out.println("Steal Count   " + pool.getStealCount());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while ((!task1.isDone()) || (!task2.isDone()) || (!task3.isDone()));
        pool.shutdown();
        System.out.println("Task 1    " + task1.join());
        System.out.println("Task 2    " + task2.join());
        System.out.println("Task 3    " + task3.join());}

}

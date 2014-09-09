package thread;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTestWithThread {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(i + "") {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "- Start " + this.getName());
                        long time = (long)Math.random()*1000;
                        Thread.sleep(time);
                        System.out.println(Thread.currentThread().getName() + "- FINISHED");
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                };
            };
            executorService.execute(t);
           
        }
        executorService.shutdown();

    }

}


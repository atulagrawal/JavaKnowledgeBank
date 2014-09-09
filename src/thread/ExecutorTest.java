package thread;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(""+i) {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "- Start " + this.getName());
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "- FINISHED " + this.getName());
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                };
            };
            executor.execute(t);
        }
        

    }

}


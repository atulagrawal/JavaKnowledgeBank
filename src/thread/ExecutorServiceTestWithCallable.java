package thread;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTestWithCallable {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            Callable<Integer> t = new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    return 10;
                }
                
            };
            try {
                Future<?> future = executorService.submit(t);
                System.out.println( future.get());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
           
        }
        executorService.shutdown();

    }

}


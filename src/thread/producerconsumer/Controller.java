package thread.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
 * Producer Consumer problem:
 * In iPhone assembly site, it takes Assembler 4-10 minutes to assemble an iPhone. 
 * Once phone is assembled, its packed into a compact box by packagers (in 20-30 sec).
 * Packages then put it inside a larger container so that it can be shipped to San Fransisco.
 * 
 */
public class Controller {
    public static void main(String[] args) {

        // producer worker pool
        ExecutorService producerService = Executors.newFixedThreadPool(2);

        // consumer worker pool
        ExecutorService consumerService = Executors.newFixedThreadPool(2);

        // broker
        Broker broker = new Broker();
        IPhoneAssemblyLine assemblyLine = new IPhoneAssemblyLine();
        IPhoneContrainer contrainer = new IPhoneContrainer();
        // submit the tasks to workers.
        for (int i = 0; i < 2; i++) {
            producerService.execute(new AssemblerTask(assemblyLine,broker));
        }
        
        for (int i = 0; i < 2; i++) {
            consumerService.execute(new PackagingTask(contrainer,broker));
        }
        
        
        while(!producerService.isShutdown()
                || !consumerService.isShutdown()) {
            
            try {
                System.out.println("----Shippment is ready with-----" + contrainer.totalBoxes() +" boxes");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

package thread.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.CustomRecursiveTask;

public class Controller {
    public static void main(String[] args) {

        // producer worker pool
        ExecutorService producerService = Executors.newFixedThreadPool(2);

        // consumer worker pool
        ExecutorService consumerService = Executors.newFixedThreadPool(2);

        // broker
        Broker broker = new Broker();

        // start producer & consumer
        producerService.execute(new Producer(broker));
        consumerService.execute(new Consumer(broker));

        producerService.shutdown();
        consumerService.shutdown();

    }
}

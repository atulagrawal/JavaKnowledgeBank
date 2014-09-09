package thread.producerconsumer;

public class Consumer implements Runnable {
    Broker broker;

    public Consumer(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void run() {
        while (broker.isActive() || broker.hasUnprocessedItems()) {
            System.out.println(Thread.currentThread().getName());
            Integer val = broker.consume();
            System.out.println("Consumed" + val);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

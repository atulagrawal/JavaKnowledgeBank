package thread.producerconsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class Broker {
    LinkedBlockingQueue<IPhone> queue;
    private boolean isActive;

    public Broker() {
        queue = new LinkedBlockingQueue();
    }

    public void put(IPhone value) {
        queue.add(value);
    }

    public IPhone get() {
        return queue.poll();
    }
    
    public boolean hashMoreIPhones() {
        return queue.size()>0;
    }
}

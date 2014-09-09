package thread.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
    ArrayBlockingQueue<Integer> queue;
    private boolean isActive;

    public Broker() {
        queue = new ArrayBlockingQueue<Integer>(100);
    }

    public void produce(Integer value) {
        queue.add(value);
    }

    public Integer consume() {
        return queue.poll();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean hasUnprocessedItems() {
        return queue.size() > 0;
    }
}

package thread.producerconsumer;

import java.util.Date;

public class PackagingTask implements Runnable {
    Broker broker;
    IPhoneContrainer container;

    public PackagingTask(IPhoneContrainer container, Broker broker) {
        this.container = container;
        this.broker = broker;
    }

    @Override
    public void run() {
        
        while (broker.hashMoreIPhones()) {
            IPhone iPhone = broker.get();
            System.out.println(Thread.currentThread().getName() + "---Packed--" + iPhone.getSerialNumber());
            IPhoneBox iPhoneBox = new IPhoneBox();
            iPhoneBox.setiPhone(iPhone);
            iPhoneBox.setPackagedDate(new Date());
            container.add(iPhoneBox);
            
            try {
                double randomVal = Math.random();
                long timeInterval = Double.valueOf(randomVal*1000).longValue();
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

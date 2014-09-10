package thread.producerconsumer;

import java.util.Date;

public class AssemblerTask implements Runnable {
    IPhoneAssemblyLine assemblyLine;
    Broker broker;
    public AssemblerTask(IPhoneAssemblyLine assemblyLine,Broker broker) {
        this.assemblyLine = assemblyLine;
        this.broker = broker;
    }

    @Override
    public void run() {
       
      
       //no more iphone
       while(assemblyLine.hasMoreIPhoneParts()) {
           IPhoneParts iPhoneParts =  assemblyLine.get();
           IPhone iPhone = new IPhone();
           iPhone.setColor("Black");
           iPhone.setModel("6");
           iPhone.setSerialNumber("123");
           System.out.println(Thread.currentThread().getName() + "---Assembled--" + iPhone.getSerialNumber());
         
           broker.put(iPhone);
           try {
               double randomVal = Math.random();
               long timeInterval = Double.valueOf(randomVal*1500).longValue();
               Thread.sleep(timeInterval);
           } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
       }

    }

}

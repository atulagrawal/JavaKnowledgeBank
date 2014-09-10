package thread.producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class IPhoneAssemblyLine {
    LinkedBlockingQueue<IPhoneParts> iPhonePartsQueue;
    public IPhoneAssemblyLine() {
        iPhonePartsQueue = new LinkedBlockingQueue<>();
        init();
    }
    
    private void init() {
        for (int i = 0; i < 20; i++) {
            /*IPhone iPhone = new IPhone();
           
            iPhoneQueue.add(iPhone);*/
            IPhoneParts iPhoneParts = new IPhoneParts();
            iPhonePartsQueue.add(iPhoneParts);
            
        }
        System.out.println("Initialization of assembly line is completed with" + iPhonePartsQueue.size() + "phones");
    }
    
    public IPhoneParts get() {
        return iPhonePartsQueue.poll();
    }

    public boolean hasMoreIPhoneParts() {
        return iPhonePartsQueue.size()>0;
    }
    
    
    
}

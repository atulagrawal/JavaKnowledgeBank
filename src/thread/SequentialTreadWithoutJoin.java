package thread;

import java.util.concurrent.CountDownLatch;

public class SequentialTreadWithoutJoin {
	 public static void main(String[] args) throws Exception {
	//	 SequentialTreadWithoutJoin.joinExample2();
		 JoinThread.joinExample1();
	 }
	 
	 /*
	  *  It is not recommended to use threads for wait, notify and notifyAll. 
	  *  One reason is this.notifyAll is called whenever a thread terminates.
	  */
	 public static void joinExample2() {
		 MyThread t = new MyThread("myThread");
	        t.start();
	      
	        synchronized(t){
	            try {
	                System.out.println("Before wait");
	                t.wait();
	                System.out.println("After wait");
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	                
	        for(int i = 0; i < 10; i++)
	            System.out.println("Thread " + Thread.currentThread().getName() + " will continue after join and print : " + i );
	 }
}


class MyThread extends Thread{
	public MyThread(String name) {
		super(name);
	}
    public synchronized void run(){
        System.out.println("Thread " + this.getName() + " will run for 1 minute");
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class JoinThread {
	public static void joinExample1() throws Exception{

		//Create a countdown latch for 1 thread. (We just need to wait for 1 thread to complete)
		CountDownLatch countDown = new CountDownLatch(1);

		//Create two threads
		Thread firstThread = new Thread(new Task(countDown));
		Thread secondThread = new Thread(new Task(countDown));
		
		//Set their names
		firstThread.setName("JobOne");
		secondThread.setName("JobTwo");
		
		//Start first thread
		firstThread.start();
		//Wait for countdown to decrease
		countDown.await();
		
		//Start second thread
		secondThread.start();
		
	}
}

class Task implements Runnable {
	CountDownLatch countLatch = null;

	public Task(CountDownLatch countDown) {
		countLatch = countDown;
	}

	@Override
	public void run() {
		for(int i = 0 ; i < 10; i++){
			System.out.println(i + " Running " + Thread.currentThread().getName());
		}
		
		//After the process is complete, decrement the countDown
		countLatch.countDown();
	}

}
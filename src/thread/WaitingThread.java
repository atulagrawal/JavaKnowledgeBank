package thread;

/*
 * This example demonstrate that if there is no call on notify then thread waits forever.
 */
public class WaitingThread {

	public static void main(String[] args) {
		Object lock = new Object();
		T t = new T(lock);
		t.start();

	}

}


class T extends Thread {
	Object lock;
	
	public T(Object lock) {
		this.lock = lock;
	}
	
	
	public void run() {
		
		synchronized (lock) {
			System.out.println("Before wait....");
			try {
				lock.wait();
				//lock.wat(2000) would be more suitable as this causes the current thread to wait 
				//until either another thread invokes the java.lang.Object.notify() method 
				//or the java.lang.Object.notifyAll() method for this object, or a specified amount of time has elapsed. 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("After Wait...");
		}
	}
}
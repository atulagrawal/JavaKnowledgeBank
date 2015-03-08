package thread;

/*
 * You can two threads. one thread print even number, other thread prints odd number. Design the threads in such a way that they togather prints numbers in natural order.
 */
public class ExmapleEvenOdd {
	public static void main(String args[]) {
		Integer max = 1000;
		Thread even = new Thread(new EvenThread(max));
		Thread odd = new Thread(new OddThread(max));
		even.start();
		odd.start();
	}
}


class EvenThread implements Runnable {
	Integer max;
	public EvenThread(Integer max) {
		this.max = max;
	}
	@Override
	public void run() {
		for(int i=0; i<=max;i++) {
			synchronized (max) {
				System.out.println(i * 2);
				max.notify();
				try {
					max.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}

class OddThread implements Runnable {
	Integer max;
	public OddThread(Integer max) {
		this.max = max;
	}
	@Override
	public void run() {
		for(int i=1; i<=max;i++) {
			System.out.println(i * 2 -1);
			synchronized (max) {
				max.notify();
				try {
					max.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
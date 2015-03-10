package thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/*
 * Thread pool is used where there are n number of tasks and each task takes relatively less time. ThreadPool is not for task that are less in numbers and take longer time
 * Idea is to save the cost in creating thread and doing context switching between them.
 */
public class ThreadPoolServiceTest {
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolService workerPool = new ThreadPoolService(3);
		//submit the task where each task takes random time to finish.
		for(int i=0;i<10;i++) {
			workerPool.submitTask(new Runnable() {
				@Override
				public void run() {
				//	System.out.println("Task is being executed");
					try {
						Integer randomSec = (int)(Math.random() * 5000);
						Thread.sleep(randomSec);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			//wait for some random time before enquing another task. Assume that a new request is being served randomly.
			try {
				Integer randomSec = (int)(Math.random() * 1000);
				Thread.sleep(randomSec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class ThreadPoolService {
	Queue<Thread> pool;
	BlockingQueue<Runnable> taskQueue;
	
	
	public Queue<Thread> getPool() {
		return pool;
	}

	public void setPool(Queue<Thread> pool) {
		this.pool = pool;
	}

	public void submitTask(Runnable task) {
		try {
			this.taskQueue.put(task);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ThreadPoolService(int size) {
		pool = new ArrayDeque<Thread>(size);
		taskQueue = new ArrayBlockingQueue<Runnable>(1000);
		for (int i = 0; i < size; i++) {
			Worker worker = new Worker(taskQueue);
			pool.add(worker);
			worker.start();
		}
	}
}


class Worker extends Thread {
	BlockingQueue<Runnable> taskQueue;
	public Worker(BlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	@Override
	public void run() {
		while(true) {
			Runnable task;
			try {
				System.out.println(this.getName() + " Maybe waiting for task..");
				task = taskQueue.take();
				task.run();
				System.out.println(this.getName() + " Completed the task..");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}


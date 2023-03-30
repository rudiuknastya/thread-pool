package lab2;

import java.util.*;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {
		TaskQueue tq = new TaskQueue();
		ThreadPool tp = new ThreadPool(tq);
		ProcessQueue pq = new ProcessQueue(tq);
		pq.start();
		tp.initialize(2);
		//pq.join();
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main woke up");
		//pq.interrupt();
		tp.stop();
		System.out.println("Stoped");
		// TODO Auto-generated method stub
		/*Queue<Integer> q = new LinkedList<>();
		int i = 1;
		long start = System.currentTimeMillis();
		long end = start + 30 * 1000;
		while (System.currentTimeMillis() < end) {
		    // Some expensive operation on the item.
			//Task task = new Task(i);
			q.add(i);
			i++;
		}
		for(int it:q) {
			System.out.println(it);
		}*/
	}

}

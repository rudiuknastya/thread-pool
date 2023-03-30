package lab2;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
	Queue<Task> q = new LinkedList<>();
	boolean empty = true;
	boolean stop = false;
	public synchronized boolean isEmpty() {
		return q.isEmpty();
	}
	public synchronized boolean isStopped(){
        return stop;
    }
	public void setStop(boolean s){
        stop = s;
    }
	public synchronized void addTask() {
		while(!empty) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		int i = 1;
		long start = System.currentTimeMillis();
		long end = start + 30 * 1000;
		System.out.println("Filling queue");
		while (System.currentTimeMillis() < end) {
		Task task = new Task(i);
		q.add(task);
		i++;
		}
		empty = false;
		notifyAll();
	}
	public synchronized Task getTask() {
		while(empty) {
			try {
				wait();
			}catch(InterruptedException e) {}
		}
		Task t = q.remove();
		if (isEmpty()) {
			empty = true;
			notifyAll();
			
		}
		return t;
	}
	
}

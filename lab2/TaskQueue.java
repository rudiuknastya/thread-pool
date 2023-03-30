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
		//if(!stop) {
		while(!empty && !stop ) {
			try {
				System.out.println("Queue is waiting");
				wait();
				//System.out.println("Queue waiting");
			}catch(InterruptedException e) {}
			System.out.println("Check queue waiting");
		}
		if(!stop) {
		int i = 1;
		long start = System.currentTimeMillis();
		long end = start + 3; //* 1000;
		System.out.println("Filling queue");
		while (System.currentTimeMillis() < end) {
		Task task = new Task(i);
		q.add(task);
		i++;
		}
		System.out.println("queue size " + q.size());
		empty = false;
		notifyAll();
		System.out.println("Queue notified");
		} else System.out.println("Queue is stoping");
	}
	public synchronized Task getTask() {
		while(empty && !stop) {
			try {
				System.out.println("Pool is waiting");
				wait();
				//System.out.println("Pool waiting");
			}catch(InterruptedException e) {}
		}
		if(!stop) {
		Task t = q.remove();
		if (isEmpty()) {
			empty = true;
			notifyAll();
			System.out.println("Pool notified");
		}
		
		return t;
		}else return null;
	}
	
}

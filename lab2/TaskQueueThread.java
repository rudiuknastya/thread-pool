package lab2;

public class TaskQueueThread extends Thread {

	TaskQueue tq;
	public TaskQueueThread(TaskQueue t) {
		tq = t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!tq.isStopped()) {
		tq.addTask();
		System.out.println("Queue addedTasks");
		}
		System.out.println("Queue thread finishing");
	}

	
}

package lab2;

public class ProcessQueue extends Thread {

	TaskQueue tq;
	public ProcessQueue(TaskQueue t) {
		tq = t;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!tq.isStopped()) {
		tq.addTask();
		}
	}

	
}

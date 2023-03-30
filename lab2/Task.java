package lab2;

import java.util.Random;

public class Task {
	private int id;
	private int duration;
	private boolean isDone = false;
	public Task (int newId) {
		Random rand = new Random();
		duration = rand.nextInt(7)+ 2; // 2-8
		id = newId;
	}

	public int getId() {
		return id;
	}
	public int getDuration() {
		return duration;
	}
	public void setIsDone(boolean newDone) {
		isDone = newDone;
	}
	public boolean getIsDone() {
		return isDone;
	}
}

package lab2;
//import static java.lang.Thread.currentThread;
public class NewThread extends Thread{

	//boolean stop = false;
	TaskQueue tq;
	int id;
	public NewThread (TaskQueue t, int ids) {
		tq = t;
		id = ids;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while (!tq.isStopped()) {
				Task ts = tq.getTask();
				try { Thread.sleep(ts.getDuration()*1000); 
				} catch (InterruptedException e) { e.printStackTrace(); }
				ts.setIsDone(true);
				System.out.println("Task " + ts.getId()+ " is done by thread "+ id);
				/*try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
	}
	//public void doStop(){
        //stop = true;
        //break pool thread out of dequeue() call.
        //Thread.currentThread().interrupt();
    //}
	//public synchronized void doStop(){
       // tq.setStop(true);
    //}

}

package lab2;

public class ThreadPool {

	NewThread []pool;
	boolean isInitialized = false;
	TaskQueue tq;
	public ThreadPool(TaskQueue t) {
		tq = t;
	}
	public void initialize(int n) {
		pool = new NewThread[n];
		for(int i = 0; i < n; i++) {
			pool[i] = new NewThread(tq, i);
			pool[i].start();
		}
		System.out.println("Pool created");
		if(pool.length > 0) {
		isInitialized = true;
		}
	}
	
	public synchronized void stop(){
		tq.setStop(true);
		//tq.empty = true;
		//for(NewThread th: pool){
			//th.doStop();
		//}
		notifyAll();
		System.out.println("Notified about stop");
        //for(NewThread th: pool){
            //try {
				//th.interrupt();
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
        //}
        
	}
	
}

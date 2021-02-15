package BackgroundWorkers;

public abstract class IBackgroundWorker implements Runnable {
	public void start() {
		Thread t =new Thread(this);
    	t.start(); 
	} 
}
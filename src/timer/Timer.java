package timer;

public class Timer {
	long time;
	int delay;
	
	public Timer() {
		
	}
	
	public void start(int delay) {
		this.delay = delay;
		time = System.currentTimeMillis();
	}
	
	public void reset() {
		time = System.currentTimeMillis();
	}
	
	public boolean done() {
		return System.currentTimeMillis() >= time+delay;
	}
}

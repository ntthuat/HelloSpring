package stackoverflow.com.pi;

import java.util.concurrent.atomic.AtomicLong;

public class Excute {
	
	public static volatile boolean running = true;
	
	public static void main(String[] args) throws InterruptedException {
		int threadCount = 8;
	    long timeoutMs = 10;
	    final AtomicLong counter = new AtomicLong(0);
	    Pithread[] threads = new Pithread[threadCount];
	    for (int i = 0; i < threadCount; i++) {
	        threads[i] = new Pithread(counter, i);
	        threads[i].start();
	    }

	    Thread.sleep(timeoutMs);
	    running = false;

	    for (int i = 0; i < threadCount; i++) {
	        threads[i].join();
	    }

	    double sum = 0;
	    for (int i = 0; i < threadCount; i++) {
	        sum += threads[i].getSum();
	    }
	    System.out.print("counter = " + counter.get());
	    System.out.print("PI = " + 4*sum);
	}
	
	static class Pithread extends Thread {
		
		private AtomicLong counter;
		private final int number;
	    private double sum  = 0;

	    public Pithread(AtomicLong counter, int number) {
	        this.counter = counter;
	        this.number = number;
	    }


	    @Override
	    public void run() {
	        long i;
	        while (running && isValidCounter(i = counter.getAndAdd(1))) {
	        	System.out.println("counter: "+counter+ "in "+number);
	            sum += Math.pow(-1, i) / (2 * i + 1);
	        }
	        System.out.println(sum);
	    }

	    private boolean isValidCounter(long value) {
	        return value >= 0 && value < Long.MAX_VALUE;
	    }

	    public double getSum() {
	        return sum;
	    }
	}
}

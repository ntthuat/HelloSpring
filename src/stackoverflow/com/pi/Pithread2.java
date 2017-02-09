package stackoverflow.com.pi;

public class Pithread2 extends Thread {
	
	private final int threadCount;
	private final int threadRemainder;
	private final int N;
	private double sum = 0;
	
	public Pithread2(int threadCount, int threadRemainder, int n) {
		this.threadCount = threadCount;
		this.threadRemainder = threadRemainder;
		N = n;
	}
	
	@Override
	public void run() {
		System.out.println(threadRemainder);
		for (int i = 0; i < N; i++) {
			System.out.println("i in "+threadRemainder+" la "+i);
			sum += Math.pow(-1, i) / (2*i + 1);
		}
	}
	
	public double getSum(){
		return sum;
	}
}

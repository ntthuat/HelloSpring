package com.springzero.java.multithread;

public class ThreadJoin implements Runnable{

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Creating " + t.getName());
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + t.getName() + ", " + i);
				// Let the thread sleep for a while.
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finishing " + t.getName());
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadJoin(),"j1");
		Thread t2 = new Thread(new ThreadJoin(),"j2");
		Thread t3 = new Thread(new ThreadJoin(),"j3");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t3.start();

		
		/*try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}

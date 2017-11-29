package com.springzero.java.multithread;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadAtomicLong extends Thread{
	
	public static volatile boolean running = true;
	
	private AtomicLong counter;
	private double sum = 0;
	
	@Override
    public void run() {
		System.out.println(running);
    }

	
}

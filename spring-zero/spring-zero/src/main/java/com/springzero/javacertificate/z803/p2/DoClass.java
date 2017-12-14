package com.springzero.javacertificate.z803.p2;

import com.springzero.javacertificate.z803.p1.DoInterface;

public class DoClass implements DoInterface{

	int x1, x2;
	
	DoClass(){
		this.x1 = 0;
		this.x2 = 10;
	}
	
	@Override
	public void m1(int n) {
		x1 += n;
		System.out.println(x1);
	}

	@Override
	public void m2(int n) {
		x2 += n;
		System.out.println(x2);
	}
	
}

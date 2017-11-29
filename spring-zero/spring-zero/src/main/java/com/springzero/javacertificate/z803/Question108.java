package com.springzero.javacertificate.z803;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Question108 {
	private int aaa;
	private int bbb;
	
	public int getAaa() {
		return aaa;
	}
	public void setAaa(int aaa) {
		this.aaa = aaa;
	}
	public int getBbb() {
		return bbb;
	}
	public void setBbb(int bbb) {
		this.bbb = bbb;
	}
	public Question108(){
	}
	public static void main(String[] args) {
		Question108 b = new Question108();
		b.setAaa(111);
		b.setBbb(123);
		Question108 c = new Question108();
		c.setAaa(111);
		c.setBbb(123);
		System.out.println(b.equals(c));
		Set<Question108> s = new HashSet();
		s.add(b);
		s.add(c);
		Map<Integer, Integer> map = new HashMap<>();
	}
}

/*class cc extends Question108{
	
}*/ //Không thể extends khi constructor là private

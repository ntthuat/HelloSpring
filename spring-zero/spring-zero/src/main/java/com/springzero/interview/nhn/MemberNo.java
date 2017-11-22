package com.springzero.interview.nhn;

public class MemberNo {
	public static void test(Member member){
		Member m = new Member();
		m.setId(100);
		m.setName("john");
		
		member = m;
		member.setName(member.getName().toUpperCase());
	}
	
	public static void main(String[] args) {
		Member member = new Member();
		member.setId(0);
		member.setName("abc");
		test(member);
		System.out.println(member.getName());
	}
}

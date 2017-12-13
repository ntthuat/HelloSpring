package com.springzero.javacertificate.z803;

public class Question140 {

	private String category = "procedura1";
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public static void main(String[] args) {
		Question140 obj1 = new Question140();
		Question140 obj2 = new Question140();
		if (obj1.getCategory() == obj2.getCategory()) {
			System.out.println("Equal");
		} else {
			System.out.println("Not equal");
		}
		if (obj1.category.equals(obj2.category)) {
			System.out.println("Equal");
		} else {
			System.out.println("Not equal");
		}
		String s = "abc";
		String s2 = new String("abc");
		String s3 = "abc";
		String s4 = new String("abc");
		System.out.println(s==s2);
		System.out.println(s==s3);
		System.out.println(s2==s4);
	}

}

package com.springzero.javacertificate.z803;

public class Question9 {
	public static void main(String[] args) {
		String string1 = new String("Thuat");
		String string2 = new String("Thuat");
		
		boolean reference = string1==string2; // it's comparing references, not values
		boolean value = string1.equals(string2); // it's comparing values, not references
		
		System.out.println(reference);
		System.out.println(value);
		
		String string3 = new String(string1); // it's only inject value to string3
		
		boolean reference2 = string1==string3;
		System.out.println(reference2);
		
		String string4 = string1; // it's inject reference
		boolean reference3 = string4==string1;
		System.out.println(reference3);
	}
}

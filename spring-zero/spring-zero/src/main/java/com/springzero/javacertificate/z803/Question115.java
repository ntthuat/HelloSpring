package com.springzero.javacertificate.z803;

public class Question115 {
	
	public static void doChange(int[] array){
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] + 1;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {10, 20, 30};
		doChange(array);
		for (int i : array) {
			System.out.println(i+", ");
		}
		/*doChange(array[0], array[1], array[2]);*/
		System.out.println(array[0]+", "+array[1]+", "+array[2]+", ");
	}
}

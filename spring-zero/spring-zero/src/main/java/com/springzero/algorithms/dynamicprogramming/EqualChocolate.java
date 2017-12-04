package com.springzero.algorithms.dynamicprogramming;

import static org.mockito.Matchers.intThat;

import java.util.HashSet;
import java.util.Set;

public class EqualChocolate {
	
	private static int extra = 0;
	
	private static int count125(int x, int y) { // y must be larger than x
		if (x>y) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		int abs = y-x;
		if (abs > 5) {
			int balance = abs/5; // balance = 103
			extra+= balance*5;
			return count125(y, x+5*(balance)) + balance;
		} else if (abs == 1) {
			extra+= 1;
			return 1;
		} else if (abs == 2) {
			extra+= 2;
			return 1;
		} else if (abs == 5) {
			extra+= 5;
			return 1;
		} else if (abs == 3) {
			extra+= 3;
			return 2;
		} else {
			extra+= 4;
			return 2;
		}
	}
	
	public static int count(Integer...array){
		int count = 0;
		for (int i = 0; i < array.length-1; i++) {
			int x = array[i];
			int y = array[i+1];
			if (x>y) {
				int temp = x;
				x = y;
				array[i] = y;
				y = temp;
				array[i+1] = temp;
			}
			count += count125(x, y+extra);
		}
		return count;
	}
	
	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);*/
		/*int n = in.nextInt();
		long[] ar = new long[n];
		for (int ar_i = 0; ar_i < n; ar_i++) {
			ar[ar_i] = in.nextLong();
		}*/
		/*String a = in.next();
		System.out.println(a);*/
		
		Integer[] array = { 53, 361, 188, 665, 786, 898, 447, 562, 272, 123, 229, 629, 670, 848, 994, 54, 822, 46, 208,
				17, 449, 302, 466, 832, 931, 778, 156, 39, 31, 777, 749, 436, 138, 289, 453, 276, 539, 901, 839, 811,
				24, 420, 440, 46, 269, 786, 101, 443, 832, 661, 460, 281, 964, 278, 465, 247, 408, 622, 638, 440, 751,
				739, 876, 889, 380, 330, 517, 919, 583, 356, 83, 959, 129, 875, 5, 750, 662, 106, 193, 494, 120, 653,
				128, 84, 283, 593, 683, 44, 567, 321, 484, 318, 412, 712, 559, 792, 394, 77, 711, 977, 785, 146, 936,
				914, 22, 942, 664, 36, 400, 857 };
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		array = set.toArray(new Integer[set.size()]);
		int result = EqualChocolate.count(array);
		System.out.println(result);
		/*System.out.println(EqualChocolate.count125(517, 5));*/
		
	}
}

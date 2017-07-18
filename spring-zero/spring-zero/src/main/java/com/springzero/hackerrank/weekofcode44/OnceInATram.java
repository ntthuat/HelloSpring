package com.springzero.hackerrank.weekofcode44;

/**
 * Class này dùng để compete week of code 44
 * 
 * <pre>
 * One day, Jack was going home by tram. When he got his ticket, he noticed that number on the ticket was not lucky. 
 * A lucky ticket is a six-digit number on the ticket in which sum of the first three digits is equal to the sum of the last three digits.
 * For example, number 165912 is lucky because sum of 1+6+5=12, and 9+1+2=12.
 * Since the number on the ticket wasn't lucky, Jack needs your help to find the next lucky ticket number.
 * For example, if Jack's ticket number is 165901, then the next lucky ticket number is 165903.
 * Given Jack's current ticket number, find and print the next lucky ticket number.
 * </pre>
 * 
 * <pre>
 * abcxyz
 * </pre>
 * 
 * @author Thuat T Nguyen
 * @version 06/13/2017
 */
public class OnceInATram {
	
	private static int a = 0, b = 0, c = 0;
	private static int resultSum = 0;
	
	static int onceInATram(int input) {
		int x = 0, y = 0, z = 0;
		int rightNum = input%1000;
		int leftNum = input/1000;
		int expectedSum = leftNum/100+leftNum/10%10+leftNum%100%10;
		do {
			if (rightNum==999) {
				leftNum++;
				x = leftNum/100;
				y = (leftNum/10)%10;
				z = leftNum%100%10;
				expectedSum = x+y+z;
				rightNum = -1;
			}
			rightNum++;
			splitNumber(rightNum);
		} while (resultSum!=expectedSum);
		return leftNum*1000+rightNum;
    }
	
	static void splitNumber(int num){
		a = num/100;
		b = (num/10)%10;
		c = num%100%10;
		resultSum = a+b+c;
	}
	

    public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		int x = in.nextInt();*/
		int x = 123987;
		int result = onceInATram(x);
		System.out.println(result);
    }
}

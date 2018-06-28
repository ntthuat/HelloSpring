package com.hackerrank.weekofcode44;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class này dùng để tìm
 * 
 * @author Thuat T Nguyen
 * @version 06/18/2017
 */
class GCDArray{
    public static int [] extractLeftHalf(int [] numbers)
    {
        int l =numbers.length/2;
        int arr[] = Arrays.copyOf(numbers, l+1);
        return arr;
    }

    public static int [] extractRightHalf(int [] numbers)
    {
        int l =numbers.length/2;
        int arr[] = Arrays.copyOfRange(numbers,l+1, numbers.length);
        return arr;
    }

    public static int gcd(int[] numbers)
    {
        if(numbers.length==1)
            return numbers[0];
        else {
            int x = numbers[0];
            int y = numbers[1];
            while(y%x!=0)
            {
                int rem = y%x;
                y = x;
                x = rem;
            }
            return x;
        }
    }
    public static int gcd(int x,int y)
    {
            while(y%x!=0)
            {
                int rem = y%x;
                y = x;
                x = rem;
            }
            return x;

    }
    public static int calculateGCD(int[] numbers){
        if(numbers.length <= 2){
            return gcd(numbers);    
        }
        else {

                    int left = calculateGCD(extractLeftHalf(numbers));
                    int right = calculateGCD(extractRightHalf(numbers));

            return gcd(left,right);
        }
    }
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }*/
    	int arr[] = {1,4,8,12,15};
        System.out.println(calculateGCD(arr));
    }
}

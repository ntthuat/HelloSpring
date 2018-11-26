package com.hackerrank;

import org.junit.Test;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/12 2:10 PM
 * $Log: ArrayManipulation.java
 */
public class ArrayManipulation {

  @Test
  public void testMain(){

    int n = 10;

    int[] result = new int[n];

    int[][] arr = new int[][]{
        {1, 5, 3},
        {4, 8, 7},
        {6, 9, 1},
    };

    for (int i = 0; i < arr.length; i++) {
      int a = arr[i][0];
      int b = arr[i][1];
      int k = arr[i][2];
      addValue(a,b,k,result);
    }

    System.out.println(getMaxValue(result));
  }

  private void addValue(int a, int b, int k, int[] result) {
    for (int i = a-1; i < b; i++) {
      result[i] += k;
    }
  }

  // getting the maximum value
  private int getMaxValue(int[] array) {
    int maxValue = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] > maxValue) {
        maxValue = array[i];
      }
    }
    return maxValue;
  }
}

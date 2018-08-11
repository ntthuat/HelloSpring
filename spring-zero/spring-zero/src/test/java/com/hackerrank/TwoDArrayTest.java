package com.hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/10 11:34 AM
 * $Log: TwoDArrayTest.java
 */
public class TwoDArrayTest {

  // Complete the hourglassSum function below.
  static int hourglassSum(int[][] arr) {
    final int i_max = arr.length - 2; //4
    final int j_max = arr[0].length - 2; //4
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < i_max; i++) {
      for (int j = 0; j < j_max; j++) {
        int tempSum = sumSub2DArray(createSub2DArray(arr, i, j));
        maxSum = tempSum > maxSum ? tempSum : maxSum;
      }
    }

    return maxSum;
  }

  static int[][] createSub2DArray(int[][] arr, int i, int j) {
    int[][] subArray = new int[3][3];
    for (int k = 0; k < 3; k++) {
      subArray[k] = Arrays.copyOfRange(arr[j], i, i + 3);
      j++;
    }
    //System.out.println(Arrays.deepToString(subArray));

    return subArray;
  }

  static int sumSub2DArray(int[][] arr) {
    int sum = arr[0][0] + arr[0][1] + arr[0][2];
    sum += arr[1][1];
    sum += arr[2][0] + arr[2][1] + arr[2][2];

    return sum;
  }


  @Test
  public void testMain() throws IOException {

    int[][] arr = new int[][]{
        {1, 1, 1, 0, 0, 0},
        {0, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0},
        {0, 0, 2, 4, 4, 0},
        {0, 0, 0, 2, 0, 0},
        {0, 0, 1, 2, 4, 0},
    };

    int result = hourglassSum(arr);
    System.out.println(result);
    Assert.assertEquals(19, result);
  }

  @Test
  public void testCreateSubArray() {
    int[] array = new int[]{1, 2, 3, 4, 5, 6};
    int[] subArray = Arrays.copyOfRange(array, 1, 3);
    System.out.println(Arrays.toString(subArray));
  }

}

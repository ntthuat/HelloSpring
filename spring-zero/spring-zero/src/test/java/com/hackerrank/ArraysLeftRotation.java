package com.hackerrank;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/11 3:55 PM
 * $Log: ArraysLeftRotation.java
 */
public class ArraysLeftRotation {

  int[] leftRotate(int arr[], int d) {
    int[] result = arr;
    for (int i = 0; i < d; i++)
      leftRotatebyOne(result);

    return result;
  }

  void leftRotatebyOne(int arr[]) {
    final int size = arr.length;
    int i, temp;
    temp = arr[0];
    for (i = 0; i < size - 1; i++)
      arr[i] = arr[i + 1];
    arr[i] = temp;
  }

  @Test
  public void testMainMethod1() {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    int[] result = leftRotate(arr, 2);
    System.out.println(Arrays.toString(result));
  }

  @Test
  public void testMainMethod2() {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    int[] result = leftRotate2(arr, 2);
    System.out.println(Arrays.toString(result));
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i] + " ");
    }
  }

  int[] leftRotate2(int arr[], int d) {
    int[] result = arr;
    int n = result.length;
    int i, j, k, temp;
    for (i = 0; i < gcd(d, n); i++) {
      /* move i-th values of blocks */
      temp = result[i];
      j = i;
      while (true) {
        k = j + d;
        if (k >= n)
          k = k - n;
        if (k == i)
          break;
        result[j] = result[k];
        j = k;
      }
      result[j] = temp;
    }

    return result;
  }

  int gcd(int a, int b) {
    if (b == 0)
      return a;
    else
      return gcd(b, a % b);
  }
}

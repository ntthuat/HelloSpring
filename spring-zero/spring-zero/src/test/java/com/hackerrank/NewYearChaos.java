package com.hackerrank;

import org.junit.Test;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/11 4:39 PM
 * $Log: NewYearChaos.java
 */
public class NewYearChaos {

  /**
   * Since the question only asks the number of bribes, there's no need to really do a sorting, nor element swapping,
   * nor "bubbling up" an element. All you need to do is to count the number of people who overtake a person.
   */
  void minimumBribes(int[] q) {
    int ans = 0;
    for (int i = q.length - 1; i >= 0; i--) {
      if (q[i] - (i + 1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
      for (int j = Integer.max(0, q[i] - 2); j < i; j++)
        if (q[j] > q[i]) ans++;
    }
    System.out.println(ans);
  }

  @Test
  public void testMain() {

  }
}

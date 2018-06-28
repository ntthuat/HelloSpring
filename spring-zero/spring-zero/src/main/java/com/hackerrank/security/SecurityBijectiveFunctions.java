package com.hackerrank.security;

import java.util.*;

public class SecurityBijectiveFunctions {

  /*public static void main(String[] args){
    int[] A = { 1,2,3 };
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    if (list.size() == set.size()){
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }*/

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      Integer x = in.nextInt();
      list.add(x);
      set.add(x);
    }
    if (list.size() == set.size()){
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
    in.close();
  }
}

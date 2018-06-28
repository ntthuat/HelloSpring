package com.hackerrank.security;

import java.io.File;
import java.util.*;

//https://www.hackerrank.com/challenges/security-function-ii/problem
public class SecurityFunctionsII {

  static int calculate(int x) {
    return x*x;
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    int result = calculate(x);
    System.out.println(result);
    in.close();
  }
}

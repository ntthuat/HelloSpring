package com.springzero.annotation.example;

import java.lang.annotation.*;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/15 10:35 AM
 * $Log: MyCustomAnnotation.java
 */
@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation{
  int studentAge() default 18;
  String studentName();
  String stuAddress();
  String stuStream() default "CSE";
}

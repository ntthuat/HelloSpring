package com.springzero.java8.repeatingannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * @author tnguyen443
 * @version 10/18/2017
 */
@Retention( RetentionPolicy.RUNTIME )
public @interface Genres {
	Genre[] value() default{};
}

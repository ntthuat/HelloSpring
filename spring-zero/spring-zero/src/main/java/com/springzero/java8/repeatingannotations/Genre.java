package com.springzero.java8.repeatingannotations;

import java.lang.annotation.Repeatable;

/**
 * https://codeaholicguy.com/2015/10/02/repeating-annotations-in-java-8/
 * 
 * @author tnguyen443
 * @version 10/18/2017
 */
@Repeatable(value = Genres.class )
public @interface Genre {
	String value();
}

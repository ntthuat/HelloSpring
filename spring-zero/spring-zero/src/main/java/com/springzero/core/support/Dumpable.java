package com.springzero.core.support;

/**
 * The interface is designed to indicate if a class should go nest dump again<br>
 * The purpose of this is when dumping a program, and all data access object and framework object can be dump as
 * well assuming it contains certain runtime information<br>
 * This interface is created for future enhancement, but it's referenced in {@link ReflectionUtil#toString()} for
 * printing dump string<br>
 * No specific behaviour is required, but more like an flag.<br>
 * 
 * @author Thuat T Nguyen
 * @version 05/30/2017
 */
public interface Dumpable {

}

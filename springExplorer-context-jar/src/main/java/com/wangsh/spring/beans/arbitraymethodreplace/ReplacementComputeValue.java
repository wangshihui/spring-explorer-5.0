package com.wangsh.spring.beans.arbitraymethodreplace;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ReplacementComputeValue  implements MethodReplacer{
	   public Object reimplement(Object o, Method m, Object[] args) throws Throwable {
	        // get the input value, work with it, and return a computed result
	        String input = (String) args[0];
	        
	        return input+"modified";
	    }
}

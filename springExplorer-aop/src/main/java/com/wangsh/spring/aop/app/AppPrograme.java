package com.wangsh.spring.aop.app;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.wangsh.spring.aop.beans.ConcurrentOperationExecutor;
import com.wangsh.spring.aop.beans.SystemArchitecture;

public class AppPrograme {
	public static void main(String... s) {
		
		SystemArchitecture systemArchitecture = new SystemArchitecture();
		// create a factory that can generate a proxy for the given target object
		AspectJProxyFactory factory = new AspectJProxyFactory(systemArchitecture);

		// add an aspect, the class must be an @AspectJ aspect
		// you can call this as many times as you need with different aspects
		factory.addAspect(ConcurrentOperationExecutor.class);

//		// you can also add existing aspect instances, the type of the object supplied must be an @AspectJ aspect
//		factory.addAspect(usageTracker);
		// now get the proxy object...
		Object proxy = factory.getProxy();

		systemArchitecture.businessService("張三");
	}
}

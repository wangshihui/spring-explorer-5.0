package com.wangsh.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangsh.spring.aop.beans.SystemArchitecture;
import com.wangsh.spring.aop.beans.UsageTracked;
import com.wangsh.spring.aop.beans.domainObject.DomaintObj;

public class AppMain {
	public static void main(String... s) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-def.xml");
		SystemArchitecture systemArchitecture=(SystemArchitecture)context.getBean("systemArchitecture");
		
		//这个是引入增强
		UsageTracked usageTracked=(UsageTracked)context.getBean("systemArchitecture");
		systemArchitecture.businessService("张三");
		usageTracked.incrementUseCount();
		System.out.println(usageTracked); 
		System.out.println("三个usageTracked的地址应该是一样的"); 
		
		DomaintObj dobj = new DomaintObj();
		dobj.run();
		
	}
}

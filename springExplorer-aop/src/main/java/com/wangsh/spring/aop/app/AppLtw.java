package com.wangsh.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import foo.DemoBean;

public class AppLtw {
	public static void main(String... d) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-ltw.xml");
		DemoBean t=context.getBean(DemoBean.class);
		t.run();
	}
}

package com.wangsh.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangsh.spring.beans.xmlBean.MyXmlbean;

public class XmlCnfTest {
	public static void main(String... s) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-def.xml");
		MyXmlbean mybean = (MyXmlbean) context.getBean("MyXmlbean");
		mybean.Say();
	}
}

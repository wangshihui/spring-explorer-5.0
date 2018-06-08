package com.wangsh.spring.beans.xmled;

import org.springframework.beans.factory.annotation.Autowired;

import com.wangsh.spring.beans.anotationed.AnotationedBean;

public class MyXmlbean {
	@Autowired
	private AnotationedBean anotationedBean;
//	@Autowired
//	com.wangsh.spring.beans.constructored.ExampleBean exampleBean;
	public void Say() {
		System.out.println(String.format("i am %s,I was configed by xml====>spring-bean-def.xml,&& i has a child %s", this,anotationedBean));
		anotationedBean.Say();
//		System.out.println(exampleBean==null);
	}
}

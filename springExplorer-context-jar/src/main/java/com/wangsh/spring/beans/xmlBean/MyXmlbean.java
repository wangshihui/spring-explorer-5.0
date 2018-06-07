package com.wangsh.spring.beans.xmlBean;

public class MyXmlbean {
	public void Say() {
		System.out.println(String.format("i am %s,I was configed by xml====>spring-bean-def.xml", MyXmlbean.class.getName()));
	}
}

package com.wangsh.spring.beans.factoryedmethod;

import com.wangsh.spring.beans.xmled.MyXmlbean;

public class FactoryBean {
	public static  MyXmlbean getMyXmlbeanInstanceStatic() {
		return new MyXmlbean();
	}
	public   MyXmlbean getMyXmlbeanInstance() {
		return new MyXmlbean();
	}
}

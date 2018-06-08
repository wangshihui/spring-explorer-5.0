package com.wangsh.spring.beans.anotationed;

import org.springframework.stereotype.Component;

@Component
public class AnotationedBean {
	public void Say() {
		System.out.println(String.format("i am %s,I was configed by annotation====>@Component", AnotationedBean.class.getName()));
	}
}

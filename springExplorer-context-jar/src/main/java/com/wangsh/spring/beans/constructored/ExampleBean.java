package com.wangsh.spring.beans.constructored;

import java.beans.ConstructorProperties;

public class ExampleBean {
	
	private int years;
	private String ultimateAnswer;
	
	
	/**
	 * @ConstructorProperties 保证jdk在运行时能够知道构造函数的参数名称
	 * @param years
	 * @param ultimateAnswer
	 */
	@ConstructorProperties({ "years", "ultimateAnswer" })
	public ExampleBean(int years, String ultimateAnswer) {
		this.years = years;
		this.ultimateAnswer = ultimateAnswer;
	}
	
	public String toString() {
		return this.years+" "+this.ultimateAnswer;
	}
}

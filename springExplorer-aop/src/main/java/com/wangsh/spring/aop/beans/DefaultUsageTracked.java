package com.wangsh.spring.aop.beans;

public class DefaultUsageTracked implements UsageTracked{

	@Override
	public void incrementUseCount() {
		System.out.println("incrementUseCount excuted......");
	}

}

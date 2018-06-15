package com.wangsh.spring.aop.beans.domainObject;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.wangsh.spring.aop.beans.SystemArchitecture;

/**
 * spring 能够装配不是被spring容器管理的类，如被编程方式new出来的 对象（领域对象）
 * 其实本质就是spring和aspectj集成，需aspectj语言能力 需要注解 @Configurable Ok
 * 单独的@Configurable并不会发挥作用，还需要spring-aspectj这个包中的AnnotationBeanConfigurerAspect支持
 * 其实就是编译时织入LTW loadtimeweaver
 * https://blog.csdn.net/evergreenfetch/article/details/42002017
 * https://blog.csdn.net/xuezhezhishen/article/details/52799011
 * 
 * @author Administrator
 *
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class DomaintObj {
	
	@Autowired
	private SystemArchitecture systemArchitecture;

	public void run() {
		systemArchitecture.businessService(DomaintObj.class.getName());
	}
}

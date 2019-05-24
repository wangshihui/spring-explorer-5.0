package com.wangsh.spring.aop.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import foo.DemoBean;
import spring.beans.ltw.LTWBean;
/**
 * load time wavering
 * 
 * 
 *  需要开启\ <context:load-time-weaver  aspectj-weaving="on" /> 
 * 
 * 或者声明bean
 * <bean id="loadTimeWeaver"   class="org.springframework.context.weaving.DefaultContextLoadTimeWeaver"></bean>
 * <bean class="org.springframework.context.weaving.AspectJWeavingEnabler"></bean>  
 * 同时在MATE-INF/aop.xml写入aspect的配置文件
 * @author Administrator
 * 
 * 

 */
public class AppLtw {
	public static void main(String... d) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-ltw.xml");
		LTWBean t=context.getBean(LTWBean.class);
		t.run();
		DemoBean t2=context.getBean(DemoBean.class);
		t2.run();
	}
}

package com.wangsh.spring.beans.javaConf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	
	/**
	 * 等价于
	 *   < beans >
     * 		< bean id="myService" class="com.acme.services.MyServiceImpl"/ >
	 *	< /beans >
	 *
	 * @return
	 */
	@Bean
	public MyService myService() {
		return new MyServiceImpl();
	}
}

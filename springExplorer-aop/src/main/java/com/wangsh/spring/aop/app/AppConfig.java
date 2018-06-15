package com.wangsh.spring.aop.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
/**
 * @EnableAspectJAutoProxy 等同于xml配置 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 * @author Administrator
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

}
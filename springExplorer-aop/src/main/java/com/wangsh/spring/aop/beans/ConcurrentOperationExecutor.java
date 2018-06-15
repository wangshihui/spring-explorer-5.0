package com.wangsh.spring.aop.beans;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

/**
 * 不论xml总的aop:config, <aop:aspectj-autoproxy></aop:aspectj-autoproxy> 还是<br>
 * 基于java配置的 @EnableAspectJAutoProxy 最终都是使用的spring aop模式（JDK代理或者CGLIB代理） 但是都需要依赖<br>
 * aspectjweaver 和 aspectjrt，而且spring 5.0。6，对这两个依赖的版本要求在1.8以上<br>
 * 
 * 默认spring为每个切面Aspect生成一个实例，但是可以通过perthis或者pertarget来改变这个行为<br>
 * 
 * spring支持的pointcut有<br>
 * execution <br>
 * within <br>
 * this <br>
 * target <br>
 * args<br>
 * &nbsp;@target <br>
 * &nbsp;@args<br>
 * &nbsp;@within<br>
 * &nbsp;@annotation<br>
 * 
 * spring aop JDK代理类，实现所有接口，然后持有原对象的实例      target！=this
 * 			  Cglib代理类 ，是直接修改字节码，生成被代理类的子类所以    target=this
 * 
 * 
 * this 和 target的区别 this表示完全相等，target表示 是否包含
 *  
 * 	
 * @author Administrator
 *
 */
@Aspect
public class ConcurrentOperationExecutor implements Ordered {
	/**
	 * 引入增强
	 */
	@DeclareParents(value = "com.wangsh.spring.aop.beans.SystemArchitecture", defaultImpl = DefaultUsageTracked.class)
	public static UsageTracked mixin;

	private static final int DEFAULT_MAX_RETRIES = 2;

	@Pointcut("execution(* com.aijava.springcode.service..*.*(..))")
	public void ConcurrentOperationExecutor() {
	}

	private int maxRetries = DEFAULT_MAX_RETRIES;
	private int order = 1;

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	// 第一种写法是报错的不知道为啥，但是官网是这样写的 纠结
	// @Around("com.wangsh.spring.aop.beans.SystemArchitecture.businessService()")
	@Around("execution(* com.wangsh.spring.aop.beans.SystemArchitecture.*(..))")
	public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before excuting businessService......");
		System.out.println(pjp.getArgs()[0]);
		return pjp.proceed(new Object[] { "李四" });
	}

	@Before("execution(* com.wangsh.spring.aop.beans.SystemArchitecture.*(..)) && this(usageTracked)")
	public void recordUsage(UsageTracked usageTracked) {
		System.out.println(usageTracked); 
		usageTracked.incrementUseCount();
	}

	@Pointcut("execution(* com.aijava.springcode.service..*.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void doBefore(JoinPoint joinPoint) {

		System.out.println("AOP Before Advice...");
	}

	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("AOP After Advice...");
	}
}

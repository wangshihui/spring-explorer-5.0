package com.wangsh.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangsh.spring.beans.anotationed.AnotationedBean;
import com.wangsh.spring.beans.arbitraymethodreplace.MyValueCalculator;
import com.wangsh.spring.beans.constructored.ExampleBean;
import com.wangsh.spring.beans.lookupmethod.CommandManager;
import com.wangsh.spring.beans.xmled.MyXmlbean;

public class XmlCnfTest {
	public static void main(String... s) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean-def.xml","spring-lookupmethod-abstractclass.xml","spring-replacemethod-arbitrary.xml");
		
		
		MyXmlbean mybean = (MyXmlbean) context.getBean("MyXmlbean");
		mybean.Say();
		
		//静态工厂方法
		MyXmlbean mybean2 = (MyXmlbean) context.getBean("MyXmlbeanByFactory1");
		mybean2.Say();
		
		//工厂方法
		MyXmlbean mybean3 = (MyXmlbean) context.getBean("MyXmlbeanByFactory2");
		mybean3.Say();
		
		System.out.println(String.format("mybean == mybean2 >>%s<< mybean2==mybean3 >>%s<< mybean1==mybean3 >>%s<<", mybean == mybean2,mybean2==mybean3,mybean==mybean3));
		
		AnotationedBean mybeanAnotation= (AnotationedBean) context.getBean("anotationedBean");
		mybeanAnotation.Say();
		
		
		ExampleBean	exampleBean =  (ExampleBean) context.getBean("exampleBean");
		System.out.println(exampleBean);
		
		ExampleBean	exampleBean2 =  (ExampleBean) context.getBean("exampleBean2");
		System.out.println(exampleBean2);
		
		CommandManager commandManager = (CommandManager)context.getBean("commandManager");
		commandManager.process("");
		
		
		MyValueCalculator	myValueCalculator = (MyValueCalculator)context.getBean("myValueCalculator");
		System.out.println(myValueCalculator.computeValue("哈哈"));
	}
}

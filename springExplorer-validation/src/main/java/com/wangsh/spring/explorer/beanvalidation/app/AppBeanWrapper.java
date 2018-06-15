package com.wangsh.spring.explorer.beanvalidation.app;

import java.beans.Beans;
import java.io.IOException;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

import com.wangsh.spring.explorer.beanvalidation.Validator.Person;

public class AppBeanWrapper {
	public static void main(String... s) {
		Person person=new Person();
		BeanWrapper personWr = new BeanWrapperImpl(person);
		
		
		personWr.setPropertyValue("name", "Some Company Inc...(1)");
		
		System.out.println(person.getName());
		PropertyValue value = new PropertyValue("name", "Some Company Inc...(2)");
		
		personWr.setPropertyValue(value);
		System.out.println(person.getName());
		
		try {
			Person javabeanP=(Person) Beans.instantiate(AppBeanWrapper.class.getClassLoader(), "com.wangsh.spring.explorer.beanvalidation.Person");
		
			System.out.println(javabeanP);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

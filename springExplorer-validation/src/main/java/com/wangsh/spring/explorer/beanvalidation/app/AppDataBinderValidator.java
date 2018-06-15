package com.wangsh.spring.explorer.beanvalidation.app;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import com.wangsh.spring.explorer.beanvalidation.Validator.Person;
import com.wangsh.spring.explorer.beanvalidation.Validator.PersonValidator;
/**
 *   Since Spring 3, a DataBinder instance can be configured with a Validator.
 *   Once configured, the Validator may be invoked by calling binder.validate().
 *   Any validation Errors are automatically added to the binder’s BindingResult.
 *   
 *   从spring3.0开始 ，可以为dataBinder的实例配置Validator，然后通过调用binder.validate(),校验
 * @author Administrator
 *
 */
public class AppDataBinderValidator {
	public static void main(String... s) {
		Person target=new Person();
		DataBinder binder = new DataBinder(target);
		binder.setValidator(new PersonValidator());
		PropertyValue value = new PropertyValue("name", "Some Company Inc...(2)");
		MutablePropertyValues mpvs = new MutablePropertyValues();
		mpvs.addPropertyValue(value);
		mpvs.add("age", -1000);
		binder.bind(mpvs );
		// validate the target object
		binder.validate();

		// get BindingResult that includes any validation errors
		BindingResult results = binder.getBindingResult();
		System.out.println(results.getErrorCount());
	}
}

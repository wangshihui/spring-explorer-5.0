package com.wangsh.spring.explorer.beanvalidation.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
	/**
	 * This Validator validates *just* Person instances
	 * 
	 * 
	 * @see java.beans.PropertyChangeListener
	 * @see java.beans.VetoableChangeListener
	 * @see https://blog.csdn.net/zhoudaxia/article/details/36247883
	 */
	public boolean supports(Class clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
		Person p = (Person) obj;
		if (p.getAge() < 0) {
//			e.rejectValue("age", "negativevalue");
		} else if (p.getAge() > 110) {
			e.rejectValue("age", "too.darn.old");
		}
	}
}

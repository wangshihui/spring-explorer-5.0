package com.wangsh.spring.explorer.beanvalidation.app;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.wangsh.spring.explorer.beanvalidation.jsr303.carJsr303;

public class AppJsr303 {
	
	/**
	 * @see https://yq.aliyun.com/articles/16934
	 * @param s
	 */
	public static void main(String... s) {
		carJsr303 car = new carJsr303();
		// hibernate 的jsr303和 的实现
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<carJsr303>> violations = validator.validate(car);
		Iterator<ConstraintViolation<carJsr303>> iter = violations.iterator();
		while (iter.hasNext()) {
			String errMessage = iter.next().getMessage();
			System.out.println(errMessage);
//			throw new ValidationException(errMessage);
		}
	}
}

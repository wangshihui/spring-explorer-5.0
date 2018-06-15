package com.wangsh.spring.explorer.beanvalidation.jsr303;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceJavaxValidator {
	@Autowired
	private Validator validator;
	
public void doValidat() {
		carJsr303 car = new carJsr303();
		car.setManufacturer(null);
		
//		validator.validate(target, errors);
	}
}

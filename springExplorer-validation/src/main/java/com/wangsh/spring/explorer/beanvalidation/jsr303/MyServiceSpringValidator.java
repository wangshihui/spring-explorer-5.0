package com.wangsh.spring.explorer.beanvalidation.jsr303;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;



@Service
public class MyServiceSpringValidator {
	@Autowired
	private Validator validator;
	
	public void doValidat() {
		
//		validator.validate(target, errors);
	}
}

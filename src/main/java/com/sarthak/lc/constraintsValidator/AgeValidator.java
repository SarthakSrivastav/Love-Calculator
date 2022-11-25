package com.sarthak.lc.constraintsValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sarthak.lc.constraints.Age;

public class AgeValidator implements ConstraintValidator<Age, Integer>{
	
	int lower;
	int upper;
	
	@Override
	public void initialize(Age age) {
		this.lower = age.lower();
		this.upper = age.upper();
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		
		if(age==null)
			return false;
		if(age<lower || age >upper)
			return false;
		
		return true;
	}

}

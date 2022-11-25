package com.sarthak.lc.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sarthak.lc.constraintsValidator.PhoneValidator;
import com.sarthak.lc.dataBinding.PhoneNum;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
	
	String message() default "{phoneMessageKey}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};


}

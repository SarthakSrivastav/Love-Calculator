package com.sarthak.lc.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sarthak.lc.constraintsValidator.AgeValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

	int lower() default 0;

	int upper() default 100;

	String message() default "{messageKey}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

package com.sarthak.lc.constraintsValidator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sarthak.lc.dataBinding.RegisterInfoDTO;

public class UserNameValidator implements Validator {

	
	//  checks if the UserNameValidator supports the given object.
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterInfoDTO.class.equals(clazz);
		// Only when we will get a RegisterInfoDTO object through the supports method, at that time
		// only our validator will be applied to the DTO Object.
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "* User Name Should Not Be Empty.");
		
		RegisterInfoDTO register = (RegisterInfoDTO) target;
		String userName = register.getUserName();
		if(!userName.isEmpty() && !userName.contains("_")) {
			errors.rejectValue("userName", "userName.invalidString", "User Name Must Contains under score('_').");
		}
		System.out.println("Hello ji "+ userName);
	}

}

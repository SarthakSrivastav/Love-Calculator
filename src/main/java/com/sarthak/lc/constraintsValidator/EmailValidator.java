package com.sarthak.lc.constraintsValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sarthak.lc.dataBinding.RegisterInfoDTO;

@Component
public class EmailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterInfoDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		String email = ((RegisterInfoDTO)target).getCommunicationInfo().getEmail();
		if(!email.isEmpty() && !email.contains("@gmail.com")) {
			errors.rejectValue("communicationInfo.email", "email.invalidEmail");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationInfo.email","communicationInfo.email.empty");
	}

}

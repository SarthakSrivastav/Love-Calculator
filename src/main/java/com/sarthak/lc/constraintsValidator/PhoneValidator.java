package com.sarthak.lc.constraintsValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.sarthak.lc.constraints.Phone;
import com.sarthak.lc.dataBinding.CommunicationDTO;

public class PhoneValidator implements ConstraintValidator<Phone, CommunicationDTO> {
	
	
	
	@Override
	public boolean isValid(CommunicationDTO communicationDTO, ConstraintValidatorContext context) {
		System.out.println("Inside isValid of Phone Anno.");
		
		if(communicationDTO.getPhoneNo()==null) {
			return false;
		}
		else {
			String phoneNum = communicationDTO.getPhoneNo().getPhoneNumber();
			String regex = "[0-9]+";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phoneNum);
			if(m.matches() && phoneNum.length()==10)
				return true;
			
			else return false;
		}
	}

}

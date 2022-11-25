package com.sarthak.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.sarthak.lc.dataBinding.PhoneNum;

public class PhoneNumberFormatter implements Formatter<PhoneNum>{

	@Override
	public String print(PhoneNum phone, Locale locale) {
		// TODO Auto-generated method stub
		System.out.println("Inside The print Method.");
		return phone.getCountryCode()+"-"+phone.getPhoneNumber();
	}

	@Override
	public PhoneNum parse(String completePhoneNum, Locale locale) throws ParseException {
		System.out.println("Inside The parse Method.");
		
		int indexOf = completePhoneNum.indexOf('-');
		
		PhoneNum phone =  new PhoneNum();
		String[] phoneNumberArr = completePhoneNum.split("-");		
		/*
		 * if(indexOf==-1) { phone.setCountryCode("91");
		 * phone.setPhoneNumber(completePhoneNum); return phone; } else {
		 * if(phoneNumberArr[0].length()==0) phone.setCountryCode("91"); else
		 * phone.setCountryCode(phoneNumberArr[0]);
		 * 
		 * phone.setPhoneNumber(phoneNumberArr[1]); return phone; }
		 */
		
//		Lets Look at more optimize solution
		if(indexOf==-1 || completePhoneNum.startsWith("-")) {
			phone.setCountryCode("91");
			
			if(completePhoneNum.startsWith("-"))
				phone.setPhoneNumber(phoneNumberArr[1]);
			else
				phone.setPhoneNumber(phoneNumberArr[0]);
		}
		else {
			phone.setCountryCode(phoneNumberArr[0]);
			phone.setPhoneNumber(phoneNumberArr[1]);
		}
		return phone;
		
		
		
		
	}

}

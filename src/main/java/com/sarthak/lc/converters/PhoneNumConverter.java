package com.sarthak.lc.converters;

import org.springframework.core.convert.converter.Converter;

import com.sarthak.lc.dataBinding.PhoneNum;

public class PhoneNumConverter implements Converter<String, PhoneNum> {

	@Override
	public PhoneNum convert(String text) {
		System.out.println("Inside The convert Method of PhoneNumConverter class.");
		int indexOf = text.indexOf('-');
		
		PhoneNum phone = new PhoneNum();
		
		String[] phoneNumberArr = text.split("-");
		if (indexOf == -1 || text.startsWith("-")) {
			phone.setCountryCode("91");

			if (text.startsWith("-"))
				phone.setPhoneNumber(phoneNumberArr[1]);
			else
				phone.setPhoneNumber(phoneNumberArr[0]);
		} else {
			phone.setCountryCode(phoneNumberArr[0]);
			phone.setPhoneNumber(phoneNumberArr[1]);
		}

		return phone;
	}

}

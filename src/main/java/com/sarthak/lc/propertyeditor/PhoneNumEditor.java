package com.sarthak.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.sarthak.lc.dataBinding.PhoneNum;

// This is not working because of the inner class concept... I will get back to this soon.
public class PhoneNumEditor extends PropertyEditorSupport {

	
	// Substitute of print method of Formatter.
	@Override
	public String getAsText() {
		PhoneNum phone  = new PhoneNum();
		return "sample : "+phone;
	}
	
	// Substitute of parse method of Formatter
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		System.out.println("Inside The setAsText Method of PhoneNumEditor class.");
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
		setValue(phone);

	}
}

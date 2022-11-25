package com.sarthak.lc.converters;

import org.springframework.core.convert.converter.Converter;

import com.sarthak.lc.dataBinding.PhoneNum;

public class ObjectToString implements Converter<PhoneNum, String>{

	@Override
	public String convert(PhoneNum source) {
		
		return "Sample : "+ source.getCountryCode();
	}
	

}

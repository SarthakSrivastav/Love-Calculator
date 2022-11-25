package com.sarthak.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:result.properties")
public class LCAppResultServiceImpl implements LCAppResultService {
	
	@Autowired
	private Environment env;

	@Override
	public String predictTheResult(String userName, String crushName) {
		String algoStr = "FLAMES";
		int unPlusCn = userName.length()+crushName.length();
		int resultChar = unPlusCn%algoStr.length();
		return env.getProperty(""+algoStr.charAt(resultChar));
	}

}

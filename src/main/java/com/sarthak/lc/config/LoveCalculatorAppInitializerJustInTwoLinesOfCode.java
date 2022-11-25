package com.sarthak.lc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LoveCalculatorAppInitializerJustInTwoLinesOfCode extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
//		Here define those classes which are the configuration classes having @Configuration Annotations.
		Class[] arr = {LoveCalculatorAppConfig.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String[] arr = {"/"}; 
		return arr;
	}

}

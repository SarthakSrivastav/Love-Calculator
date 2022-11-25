package com.sarthak.lc.config;

import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sarthak.lc.converters.ObjectToString;
import com.sarthak.lc.converters.PhoneNumConverter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.sarthak.lc.controller", "com.sarthak.lc.constraintsValidator", "com.sarthak.lc.service" })
@PropertySource("classpath:email.properties")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {
	int count = 0;
	
	Logger logger = Logger.getLogger(LoveCalculatorAppConfig.class.getName());

	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		System.out.println("Inside messageSource " + count++);
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.addBasenames("message");// here message is the file name.
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		System.out.println("Inside validator " + count++);
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;

	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		logger.info(">>>>>>>>>>Inside JavaMailSender Start");
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		
		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
		javaMailSenderImpl.setUsername(env.getProperty("mail.sender"));
		javaMailSenderImpl.setPassword(env.getProperty("mail.pass"));
		javaMailSenderImpl.setPort(Integer.parseInt(env.getProperty("mail.port")));
		
		javaMailSenderImpl.setJavaMailProperties(getMailProperty());
		
		System.out.println("Inside JavaMailSender End");
		return javaMailSenderImpl;
	}
	@Override
	public Validator getValidator() {
		System.out.println("Inside getValidator " + count++);
		return validator();
	}

	// Registering the formatter
	/*
	 * @Override public void addFormatters(FormatterRegistry registry) {
	 * System.out.println("Registring The Formatter."); registry.addFormatter(new
	 * PhoneNumberFormatter()); }
	 */

	// Registering the converter

	@Override
	public void addFormatters(FormatterRegistry registry) {
		System.out.println("Registring The Formatter.");
		registry.addConverter(new PhoneNumConverter());
		registry.addConverter(new ObjectToString());
	}
	
	
	
	
	private Properties getMailProperty() {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		return mailProperties;
	}


}

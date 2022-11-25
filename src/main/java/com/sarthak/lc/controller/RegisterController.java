package com.sarthak.lc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sarthak.lc.constraintsValidator.EmailValidator;
import com.sarthak.lc.constraintsValidator.UserNameValidator;
import com.sarthak.lc.dataBinding.CommunicationDTO;
import com.sarthak.lc.dataBinding.PhoneNum;
import com.sarthak.lc.dataBinding.RegisterInfoDTO;
import com.sarthak.lc.propertyeditor.NamePropertyEditor;

@Controller
public class RegisterController {
	
	@Autowired
	private EmailValidator emailValidator;
	
	@RequestMapping("/register")
	public String Register(@ModelAttribute("registerUser") RegisterInfoDTO registerInfo) {
		System.out.println("inside /register");
//		RegisterInfoDTO registerInfo = new RegisterInfoDTO();
//		registerInfo.setName("Anubhav");
//		registerInfo.setUserName("anu@123");
//		model.addAttribute("registerUser",registerInfo);

		PhoneNum phone = new PhoneNum();
		phone.setCountryCode("91");
		phone.setPhoneNumber("7800359920");
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhoneNo(phone);
		registerInfo.setCommunicationInfo(communicationDTO);
		// From here the controller will go to the PhoneNumberFormatter Class
		// print method to show the above assigned default value on to the page.
		return "register";
	}

	@RequestMapping("/validateRegistration")
	public String validateRegistration(@Valid @ModelAttribute("registerUser") RegisterInfoDTO registerUser,
			BindingResult result) {

		System.out.println("inside /validateRegistration");
		System.out.println(registerUser.getCommunicationInfo().getPhoneNo());

//		Checking if I am able to call the Custom Email Validator or not?
		emailValidator.validate(registerUser, result);

		/*
		 * List<ObjectError> allErrors = result.getAllErrors();
		 * 
		 * for(ObjectError error : allErrors) { System.out.println(error); }
		 */

		if (result.hasErrors()) {
			return "register";
		}
		return "welcome";
//		Note: "registerUser" is declaring inside the form:form tag (modelAttribute) 

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside Init Buinder.");
//		binder.setDisallowedFields("name","userName");

		StringTrimmerEditor editor = new StringTrimmerEditor(true); // Here true/false controls the null/empty value
		binder.registerCustomEditor(String.class, "name", editor);

		NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", namePropertyEditor);

		// Instead of registering the formatter from the Config class we can register it
		// from here also.
//		 binder.addCustomFormatter(new PhoneNumberFormatter());

		// Instead of using Formatter we can use Custom Editors also.
//		PhoneNumEditor phoneNumEditor = new PhoneNumEditor();
//		binder.registerCustomEditor(PhoneNum.class, "phoneNo", phoneNumEditor);

//		Registering the UserNameValidator which comes from org.springframework.validation.Validator
		UserNameValidator userNameValidator = new UserNameValidator();
		binder.addValidators(userNameValidator);

//		EmailValidator emailValidator = new EmailValidator();
//		binder.addValidators(emailValidator);

	}

}

//Can we manually call our validators? Let's check it out.
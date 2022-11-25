package com.sarthak.lc.dataBinding;

import javax.validation.constraints.NotEmpty;

import com.sarthak.lc.constraints.Age;
import com.sarthak.lc.constraints.Phone;

public class RegisterInfoDTO {

	@NotEmpty(message = "{string.notEmpty}")
	private String name;
	private String userName;
	private String password;
	private String country;
	private String[] hobby;
	private String gender;
	
	
	@Phone(message = "* Please provide the valid phone number.")
	private CommunicationDTO communicationInfo;
	
	@Age(lower = 18, upper = 60)//,message = "* Only working professionals are allowed in my organization."
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CommunicationDTO getCommunicationInfo() {
		return communicationInfo;
	}

	public void setCommunicationInfo(CommunicationDTO communicationInfo) {
		this.communicationInfo = communicationInfo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}

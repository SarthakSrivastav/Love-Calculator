package com.sarthak.lc.dataBinding;

import javax.validation.constraints.NotNull;

public class CommunicationDTO {
	
	private String email;
	private PhoneNum phoneNo;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull
	public PhoneNum getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(PhoneNum phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	
	

}

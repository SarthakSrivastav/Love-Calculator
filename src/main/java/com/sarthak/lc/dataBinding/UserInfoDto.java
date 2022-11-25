package com.sarthak.lc.dataBinding;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDto {
	
	@NotBlank(message = "* Your Name Can Not Be Blank.")
	@Size(min = 3, max = 15, message = "Your Name Should Have Character Between 3-15")
	private String userName;
	private String crushName;
	
	private String result;
//	private Date date;
	
	@AssertTrue(message = "* You Have To be Agree To our Terms And Conditions To Use This Application.")
	private boolean signAgreement;
	
	
	public UserInfoDto() {
//		System.out.println("This is UserInfoDto counstructor invoked by the Spring itself");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
//		System.out.println("Setting the userName");
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
//		System.out.println("Setting the crushName");
		this.crushName = crushName;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isSignAgreement() {
		return signAgreement;
	}

	public void setSignAgreement(boolean signAgreement) {
		this.signAgreement = signAgreement;
	}

//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}


}

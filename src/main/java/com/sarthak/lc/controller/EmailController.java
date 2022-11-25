package com.sarthak.lc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sarthak.lc.dataBinding.EmailDTO;
import com.sarthak.lc.dataBinding.UserInfoDto;
import com.sarthak.lc.service.LCAppEmailServiceImpl;
import com.sarthak.lc.service.LCAppResultService;

@Controller
public class EmailController {
	
	
	@Autowired
	private LCAppEmailServiceImpl lcAppEmailServiceImpl;
	
	@Autowired
	private LCAppResultService lcAppResultService;

//	Drawbacks of sending data threw PathVariable
//	1. Not Secure Any one can Modify the url and featch your data.
//	2. You have to provide every where the same pathVariable where ever you need it.

	/*
	 * @RequestMapping("/sendEmail/{userName}") public String
	 * sendEmail(@PathVariable Map<String, String> pathVariable, Model model) {
	 * // @PathVariable("userName") String name
	 * 
	 * model.addAttribute("emailDto", new EmailDTO());
	 * model.addAttribute("userName", pathVariable.get("userName").toUpperCase());
	 * System.out.println("inside /sendEmail/{userName}"); return "send-email-page";
	 * }
	 */

	// Working with Cookies
	/*
	 * @RequestMapping("/sendEmail") public String
	 * sendEmail(@CookieValue("lcApp.userName") String userName, Model model) {
	 * // @PathVariable("userName") // String name model.addAttribute("emailDto",
	 * new EmailDTO()); model.addAttribute("userName", userName); return
	 * "send-email-page"; }
	 */

	/*
	 * @RequestMapping("/validateEmailID") public String
	 * validateEmail(@CookieValue("lcApp.userName") String
	 * userName, @RequestParam("email") String emailId, Model model) {
	 * 
	 * EmailDTO dto = new EmailDTO(); dto.setEmail(emailId);
	 * 
	 * model.addAttribute("emailDto", dto); model.addAttribute("userName",
	 * userName);
	 * 
	 * System.out.println("inside /validateEmailID");
	 * 
	 * return "process-email-page"; }
	 */

	
	
	//Working with Sessions.
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model, HttpSession session) { // @PathVariable("userName")
											// String name
		UserInfoDto dto = (UserInfoDto)session.getAttribute("userInfo");
		
		model.addAttribute("userInfo", dto);
		model.addAttribute("emailDto", new EmailDTO());
		return "send-email-page";
	}

	@RequestMapping("/validateEmailID")
	public String validateEmail(@ModelAttribute("emailDto") EmailDTO dto, @SessionAttribute("userInfo") UserInfoDto userInfoDto) {


		System.out.println("inside /validateEmailID");
		
		//Send Email Service
		lcAppEmailServiceImpl.sendEmail(userInfoDto.getUserName(),dto.getEmail(), userInfoDto.getResult());

//		lcAppEmailServiceImpl.sendEmail(userInfoDto.getUserName(),dto.getEmail(), lcAppResultService.predictTheResult(userInfoDto.getUserName(), userInfoDto.getCrushName()));

		return "process-email-page";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}























package com.sarthak.lc.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sarthak.lc.dataBinding.UserInfoDto;
import com.sarthak.lc.service.LCAppResultService;

@Controller
@SessionAttributes({"userInfo"})
public class LCAppController {
	
	@Autowired
	private LCAppResultService lcAppResultService;

	// Working with Cookies.
	/*
	 * @RequestMapping("/") public String homePage(@ModelAttribute("userInfo")
	 * UserInfoDto userInfo, HttpServletRequest request) {
	 * System.out.println("inside /"); Cookie[] cookie = request.getCookies();
	 * 
	 * if (cookie!=null) { for (Cookie cook : cookie) { if
	 * ("lcApp.userName".equals(cook.getName()))
	 * userInfo.setUserName(cook.getValue());
	 * 
	 * } } // UserInfoDto userInfo = new UserInfoDto(); //
	 * model.addAttribute("userInfo", userInfo);
	 * 
	 * return "home-page"; }
	 */

	/*
	 * @RequestMapping("/process-homepage") public String
	 * processHomePage(@Valid @ModelAttribute("userInfo") UserInfoDto userInfo,
	 * BindingResult result, HttpServletResponse response) {
	 * System.out.println("Inside /process-homepage");
	 * System.out.println("Agreement : " + userInfo.isSignAgreement()); if
	 * (result.hasErrors()) { return "home-page"; }
	 * 
	 * // Create a cookie for the userName Cookie cookie = new
	 * Cookie("lcApp.userName", userInfo.getUserName()); cookie.setMaxAge(60 * 60 *
	 * 24); // add the cookie to the response response.addCookie(cookie); return
	 * "result-page"; }
	 */

	// Working with Sessions.
	@RequestMapping("/")
	public String homePage(Model model) {
		model.addAttribute("userInfo", new UserInfoDto());
		System.out.println("inside /");
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	public String processHomePage(@Valid @ModelAttribute("userInfo") UserInfoDto userInfo, BindingResult result, Model model, SessionStatus status) {
		
//		Important Note: If you are not using  @ModelAttribute then you have to add all the necessary things into your Model by yourself.
//		eg: model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"userInfo", result);
//		also note if you are not using the @ModelAttribute then you have to write @Valid annotation Before the model object and you have to 
//		also add that model object into your model.
		
//		System.out.println("Inside /process-homepage");
//		System.out.println("Agreement : " + userInfo.isSignAgreement());
		
		// Below four lines of code is proving that @SessionAttribute is accessible inside the different Request Scope.
		UserInfoDto dto = (UserInfoDto) model.getAttribute("userInfo");
		String userName = dto.getUserName();
		String crushName = dto.getCrushName();
		System.out.println("User Name = "+userName+", Crush Name = "+crushName);
		
		
		if (result.hasErrors()) {
			return "home-page";
		}
		
//		Calling service to predict the result.
		 dto.setResult(lcAppResultService.predictTheResult(userName, crushName));
		//removing the session attributes from the session itself.
//		status.setComplete();
		return "result-page";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside initBinder of LCAppController.");

		SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", customDateEditor);

	}

//	@RequestMapping("/")
//	public String homePage() {
//		return "sign-in";
//
//	}

//	@RequestMapping("/login")
//	public String logIn(@ModelAttribute("loginInfo") LoginInfoDTO loginInfo) {
//		return "result-page";
//	}

}
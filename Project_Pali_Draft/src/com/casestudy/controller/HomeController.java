package com.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.models.User;
import com.casestudy.services.HomeServices;
import com.casestudy.services.InGameWordServices;
import com.casestudy.services.UserServices;

@Controller
@SessionAttributes({"gameStatus", "userLogin"}) //Set/Declare the object in the session
public class HomeController {
	
	@ModelAttribute("gameStatus")
	public boolean setUpGameStatus() { //Creating the object in the session. Gamestate is false, meaning game is off.
		return false; //Game is off
	}
	
	@RequestMapping(value = {"/", "/Login"})
	public String loginHandler() {
		return "Login";
	}
	
	@ModelAttribute("userLogin")
	public User setUpUserLogin()  { //Creating the object in the session. Set up a User . Line 9 of PreGame. Like creating an instance of the object. Instatation
		return new User();
	}
	
/*	@RequestMapping(value = {"/loggedIn"})
	public ModelAndView loggedInHandler(@ModelAttribute("userLogin")@Valid User u, BindingResult errors) {
		ModelAndView mavUserLogin = new ModelAndView("HomePage");
		UserServices us = new UserServices();
		mavUserLogin.addObject("us", us.getUserByIdService(u.getUserId()));
		System.out.println(us.getUserByIdService(u.getUserId()));
//		if(errors.hasErrors()) {
//			mavUserLogin.setViewName("ErrorPage");
//			mavUserLogin.addObject("us", "Login Error, try again");
//			return mavUserLogin;
//		}
		return mavUserLogin;
	} */
	
	@RequestMapping(value = {"/Register"})
	public String registerHandler() {
		return "Register";
	}
	
	@RequestMapping(value = {"/HomePage"})
	public ModelAndView homeMAVHandler() {
		ModelAndView mavHomePage = new ModelAndView("HomePage"); 		 
		HomeServices hs = new HomeServices();
		int randVerses = (int) ((int) 1+Math.random()*4);
		mavHomePage.addObject("hs", hs.getHomeVerseServicesInt(randVerses).toString());
		return mavHomePage; //HomePage.jsp	
	}
	
	@RequestMapping(value = {"/HomePageGuest"})
	public ModelAndView homeGuestMAVHandler() {
		ModelAndView mavHomePage = new ModelAndView("HomePageGuest"); 		 
		HomeServices hs = new HomeServices();
		int randVerses = (int) ((int) 1+Math.random()*4);
		mavHomePage.addObject("hs", hs.getHomeVerseServicesInt(randVerses).toString());
		return mavHomePage; //HomePage.jsp	
	}
	
	@RequestMapping("/Settings")
	public String settingsHandler() {
		return "Settings";
	}
	
	@RequestMapping("/SettingsGuest")
	public String settingsGuestHandler() {
		return "SettingsGuest";
	}
	
	@RequestMapping("/InGamePreGame")
	public ModelAndView inGamePreGameHandler() { //Read
		ModelAndView mav = new ModelAndView("InGamePreGame");
		mav.addObject("gameStatus", false);
		return mav;
	}
	
	@RequestMapping("/InGamePreGameGuest")
	public ModelAndView inGamePreGameGuestHandler() { //Read
		ModelAndView mav = new ModelAndView("InGamePreGameGuest");
		mav.addObject("gameStatus", false);
		return mav;
	}
	
	@RequestMapping("/signUp")
	public ModelAndView signUpHandler(@ModelAttribute("userRegister") User newUser) {
		String viewName = "Register";
		int result = 0;
		String message = "";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		
		UserServices us = new UserServices();
		boolean userExist = us.getUserByIdService(newUser.getUserId()) != null;
		if(userExist) {
			message = "User already exist";
			result = 0;
			mav.setViewName("ErrorPage");
		} else {
			result = us.createUserService(newUser);
			message = result==1 ? "User saved" : "TRANSACTION FAILURE, please try again.";
		}
		
		mav.addObject("xMessage", message);
		
		message = result==1?"Congratulations":"ERROR";
		return mav.addObject("xMessageTitle", message);
		
	}
	
	@RequestMapping("/ErrorPage")
	public String errorPageHandler() {
		return "ErrorPage";
	}
	
	
/*	@RequestMapping("/Leaderboards")
	public ModelAndView leaderboardsHandler() {
		ModelAndView mavLeaderboards = new ModelAndView();
		//MAY NEED TO ADD DATATYPE IN MODEL/ENTITY CLASS FOR PRIVATE BIO + YOUR PIC. REFER TO OLD MARICAL PROJECT 
		//WITH USE OF MEDIA FOLDER FOR IMG'S. THIS HANDLER MAY DEAL WITH GATHERING INFORMATION FROM USER + SCORE. 
		//USING 3 CRUD METHODS I ANTICIPATE (INSERT, SELECT, UPDATE)   
		return mavLeaderboards;
	} */
}
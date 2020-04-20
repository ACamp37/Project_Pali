package com.casestudy.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.models.InGameWord;
import com.casestudy.services.InGameWordServices;

@Controller
@SessionAttributes({"gameStatus"})
public class InGameController {
	
	int scoreRecOutput = 0;
	int scoreHighOutput = 0;
	InGameWordServices igs = new InGameWordServices();
	
	@RequestMapping(value="InGameURI") //Method is POST. Specified on front end form on JSP page ("InGameGuest.jsp). Guest side application.
	public ModelAndView inGameMAVHandler
	(@ModelAttribute("userInput") InGameWord fromInput, 
			@SessionAttribute("gameStatus") boolean gameStatus) { //this is to get user input and the status of the game.  
		ModelAndView mavInGame = new ModelAndView("InGame"); //URL pointing to InGameGuest.jsp
		System.out.println("************************************game status is: " + gameStatus); //Game is on
		
		int counter = InGameWordServices.gameTimeInSecs; //Assigns the timer seconds (20) to this counter. 
		int randWords = (int) ((int) 1+Math.random()*4); //maybe in future, * the length of list of words instead of a hardcoded 4
		fromInput.setRecentScore(scoreRecOutput);
		fromInput.setHighScore(scoreHighOutput);
		mavInGame.addObject("igs", igs.getInGameServicesInt(randWords).toString()); //Add this to the JSP view
		
		if(gameStatus) { //if gameStatus is on aka true aka if the game is on
			System.out.println("*******************GAME ON");
			System.out.println(igs.getInGameServicesInt(randWords).toString()); //GET RID OF THIS LINE WHEN I FIX THE PROPER WORD COMING. 
			if(counter > 0 && Objects.equals(fromInput.getWordName(), igs.getInGameServicesInt(randWords).toString())) {
				System.out.println(scoreRecOutput++); 
				System.out.println(scoreHighOutput++);
				System.out.println(fromInput.getWordName()); //show inputed word when correct
				System.out.println(igs.getInGameServicesInt(randWords).toString()); //show word from DB when correct
			}
			else if(counter <= 0 && fromInput != null){ //else if its less than 0 && user attempts to input anything
				mavInGame.addObject("gameStatus", false); //turns off the gamestatus. Game is Over
				scoreRecOutput = 0;
				System.out.println("Game is Over");
				System.out.println(scoreRecOutput+=0);
				mavInGame.setViewName("InGamePostGame");
			}
		} else { // else if gameStatus is off aka false aka if the game is off
			System.out.println("**********************GAME OFF");
			igs.gameTimer(); //Starts my timer
			mavInGame.addObject("gameStatus", true); //turns on the gamestatus. The game is on
		}
		mavInGame.addObject("recentScore", fromInput.getRecentScore()); //Add this to the JSP view
		mavInGame.addObject("highScore", fromInput.getHighScore()); //Add this to the JSP view
		return mavInGame; //InGame.jsp	
	}
	
	@RequestMapping(value="InGameGuestURI") //Method is POST. Specified on front end form on JSP page ("InGameGuest.jsp). Guest side application.
	public ModelAndView inGameGuestMAVHandler
	(@ModelAttribute("userInput") InGameWord fromInput, 
			@SessionAttribute("gameStatus") boolean gameStatus) { //this is to get user input and the status of the game.  
		ModelAndView mavInGame = new ModelAndView("InGameGuest"); //URL pointing to InGameGuest.jsp
		System.out.println("************************************game status is: " + gameStatus); //Game is on
		
		int counter = InGameWordServices.gameTimeInSecs; //Assigns the timer seconds (20) to this counter. 
		int randWords = (int) ((int) 1+Math.random()*4); //maybe in future, * the length of list of words instead of a hardcoded 4
		fromInput.setRecentScore(scoreRecOutput);
		mavInGame.addObject("igs", igs.getInGameServicesInt(randWords).toString()); //Add this to the JSP view
		
		if(gameStatus) { //if gameStatus is on aka true aka if the game is on
			System.out.println("*******************GAME ON");
			System.out.println(igs.getInGameServicesInt(randWords).toString()); //GET RID OF THIS LINE WHEN I FIX THE PROPER WORD COMING. 
			if(counter > 0 && Objects.equals(fromInput.getWordName(), igs.getInGameServicesInt(randWords).toString())) {
				System.out.println(scoreRecOutput++); 
				System.out.println(fromInput.getWordName()); //show inputed word when correct
				System.out.println(igs.getInGameServicesInt(randWords).toString()); //show word from DB when correct
			}
			else if(counter <= 0 && fromInput != null){ //else if its less than 0 && user attempts to input anything
				mavInGame.addObject("gameStatus", false); //turns off the gamestatus. Game is Over
				scoreRecOutput = 0;
				System.out.println("Game is Over");
				System.out.println(scoreRecOutput+=0);
				mavInGame.setViewName("InGamePostGameGuest");
			}
		} else { // else if gameStatus is off aka false aka if the game is off
			System.out.println("**********************GAME OFF");
			igs.gameTimer(); //Starts my timer
			mavInGame.addObject("gameStatus", true); //turns on the gamestatus. The game is on
		}
		mavInGame.addObject("recentScore", fromInput.getRecentScore()); //Add this to the JSP view
		return mavInGame; //InGame.jsp	
	}
	
}
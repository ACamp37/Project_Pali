package com.casestudy.services;

import java.util.Timer;
import java.util.TimerTask;

import com.casestudy.dao.InGameDAO;
import com.casestudy.models.InGameWord;

public class InGameWordServices {
	
	public static Timer timer;
	public static TimerTask task;
	public static int gameTimeInSecs = 120;
	InGameWord igw = new InGameWord();
	
/*	public static void main(String[] args) {
//		testGetInGameWordById();
//		InGameTimer();
		gameTimerOption();
	} */  
	
/*	public static void testGetInGameWordById() {
		int getWord = 3;
		InGameWord foundWord = getInGameServicesInt(getWord);
		if(foundWord==null) {
			System.out.println("ERROR: Word does not exist");
		} else {
			System.out.println("Word Found = " + foundWord.toString());
		}
	} */ 
	
	//This is all a method for Getting! aka Finding! aka SELECTING! 
	public InGameWord getInGameServicesInt(int getWord) {
		InGameDAO inGameDao = new InGameDAO();
		InGameWord foundWord = inGameDao.getInGameWord(getWord); //Finds/Gets my word
//		timer = new Timer(); //Get associated timer to go with game
//		TimerTask task = new InGameWordServices();
//		timer.scheduleAtFixedRate(task, 1000, 1000); //NEED TO ADJUST THIS TIME APPROPRIATELY
//		timerForGame(foundWord);
		return foundWord;
		//FOR CONNECTION TO INPUT ALONG WITH SCORE OF GAME, HANDLE REQUEST/RESPONSE IN SPRING CONTROLLER
	}
	
	public Timer gameTimer() {
		task = new TimerTask() { //task calls this class each time
		
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Timer " + --gameTimeInSecs);
		if(gameTimeInSecs <= 0) {
			task.cancel();
			timer.cancel();
			timer.purge();
		}
	}
	};
	timer = new Timer(); //Creates a new timer.
	startGame();
	
	timer.scheduleAtFixedRate(task, 1000, 1000); //NEED TO ADJUST THIS TIME APPROPRIATELY
		return timer;
	}
	
	public void startGame() {
		gameTimeInSecs = 120;
		System.out.println("Timer" + gameTimeInSecs);
	}
	
}

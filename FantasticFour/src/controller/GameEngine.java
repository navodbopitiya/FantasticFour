/**
 * 
 */
package controller;

import javafx.application.Application;
import view.MainMenuView;


/**
 * @author Navod Bopitiya
 *
 */
public class GameEngine {
	
	private String playerOneName, playerTwoName;
	private int roundTime;
	
	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	public void setRoundTime(int roundTime) {
		this.roundTime = roundTime;
	}

	public void startGame(){
		Application.launch(MainMenuView.class);
		System.out.println("Just checking");
	}

}

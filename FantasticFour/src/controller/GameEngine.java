/**
 * 
 */
package controller;

import view.Board;
import view.BoardView;
import view.MainMenuView;
import model.GameConstants.GAME_STATE;
import model.Player;

public class GameEngine implements CheckGameState {
	private GAME_STATE gameStauts = GAME_STATE.NITIALIZED;

	/**
	 * Access the Board class
	 */
	private Board board;

	/**
	 * Access the playerA class
	 */
	private Player playerA;

	/**
	 * Access the playerB class
	 */
	private Player playerB;

	/**
	 * whose turn
	 */
	private Player currentPlayer;
	private String playerOneName, playerTwoName;
	private int timerValue;
	private boolean dataEntered = false;

	public void setDataEnteredValue(boolean dataEntered) {
		this.dataEntered = dataEntered;
	}

	public void setPlayerOneName(String playerOneName) {
		this.playerOneName = playerOneName;
	}

	public void setPlayerTwoName(String playerTwoName) {
		this.playerTwoName = playerTwoName;
	}

	public void setTimerValue(int timerValue) {
		this.timerValue = timerValue;
	}

	public GameEngine() {
	}

	public GameEngine(boolean gameStart) {
		if (gameStart) {
			startMainMenu();
			while (this.dataEntered != true) {
				//do nothing while user hasn't entered data
				System.out.println("You are in while loop"); //TODO- remove test print
			}
			startGame();
			System.out.println("You are out of while loop");//TODO- remove test print
		}

	}

	@Override
	public Player getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printText() {
		System.out.printf("You're in the Game Engine! %n Player one Name: %s%n Player Two Name: %s%n Timer Value: %d%n",
				playerOneName, playerTwoName, timerValue); //TODO- remove test print
	}

	public void startMainMenu() {
		//Start Main Menu 
		MainMenuView mainMenuView = new MainMenuView(this);
		mainMenuView.run();
	}

	public void startGame() {
		//Start Board
		System.out.println("You are in startGame()"); //TODO- remove test print
		BoardView boardView = new BoardView(this);
		boardView.run();
	}
}

/**
 * 
 */
package controller;
import javax.swing.JFrame;

import model.GameConstants.GAME_STATE;
import model.GameConstants.PLAYER_SIDE;
import model.Board;
import model.LegendSquare;
import model.Piece;
import model.Player;
import view.BoardView;
import view.MainMenuView;



public class GameEngine implements CheckGameState
{
	/**
	 * the game state
	 * could be NITIALIZED, SETTLE, PLAYING, PAUSED, GAMEOVER
	 */
	private static GAME_STATE gameStauts = GAME_STATE.INITIALIZED;
	
	/**
	 * Access the Board class
	 */
	private Board boardFrame;
	
	/**
	 * Access the playerA class
	 */
	private static Player playerA;
	
	/**
	 * Access the playerB class
	 */
	private static Player playerB;
	
	/**
	 * whose turn
	 */
	private static Player currentPlayer;
	
	/**
	 * Current Legend Piece
	 */
	private static Piece currentPiece;
	
	/**
	 * Current Legend Square
	 */
	private static LegendSquare currentLegendSquare;
	
	/**
	 * time limitation per round
	 */
	private int timerValue;

	/**
	 * the view to display the game board
	 */
	private static BoardView boardView;
	
	/**
	 * initializ two Players
	 * @param PlayerA_name
	 * @param PlayerB_name
	 */
	private void initPlayer(String PlayerA_name,String PlayerB_name)
	{
		playerA = new Player(PLAYER_SIDE.NORTH,PlayerA_name);
		playerB = new Player(PLAYER_SIDE.SOUTH,PlayerB_name);
		currentPlayer = playerA;
	}
	
	/**
	 * initialized the game board
	 * to add Board Panel
	 * to add two LegendPanel
	 */
	private void initBoard()
	{
		boardFrame = new Board();
		boardFrame.setLegendPanel(playerA);
		boardFrame.setBoardPanel();
		boardFrame.setLegendPanel(playerB);
		
		LegendSquare[] ls = currentPlayer.getLegendPanel().getLegendSquares();
		for(int i=0; i<ls.length; i++)
		{
			ls[i].setEnabled(true);
		}
		
		currentPlayer.getLegendPanel().getBtnGo().setEnabled(true);
		
		boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * start the login window
	 */
	public void startMainMenu()
	{
		MainMenuView mainMenuView = new MainMenuView(this);
		mainMenuView.run();
	}
	
	/**
	 * initialize Player A and Player B
	 * initialize current player
	 * initialize time limitation per round
	 * initialize game board
	 */
	public void initialize(String PlayerA_name,String PlayerB_name,int timerValue) 
	{
		initPlayer(PlayerA_name, PlayerB_name);
		this.timerValue = timerValue;
		initBoard();
		openBoardView();
	}
	
	/**
	 * open the BoardView
	 */
	public void openBoardView()
	{
		boardView = new BoardView(this);
		boardView.display();
	}
	
	public static void changePlayer()
	{
		if (currentPlayer == playerA)
		{
			currentPlayer = playerB;
			playerA.getLegendPanel().getBtnGo().setEnabled(false);
			playerA.getLegendPanel().getLblPlayerName().setText(playerA.getPlayername());
			playerB.getLegendPanel().getBtnGo().setEnabled(true);
			playerB.getLegendPanel().getLblPlayerName().setText("*"+playerB.getPlayername()+"*");
			
			
		}else
		{
			currentPlayer = playerA;
			playerA.getLegendPanel().getBtnGo().setEnabled(true);
			playerA.getLegendPanel().getLblPlayerName().setText("*"+playerA.getPlayername()+"*");
			
			playerB.getLegendPanel().getBtnGo().setEnabled(false);
			playerB.getLegendPanel().getLblPlayerName().setText(playerB.getPlayername());
		}
		playerA.setMoved(false);
		playerB.setMoved(false);
		
		if (playerA.getLegendSquare().size() == 0 && playerB.getLegendSquare().size() == 0)
		{
			startGame();
		}
		
		if (gameStauts==GAME_STATE.INITIALIZED)
		{
			LegendPanelController lpController = new LegendPanelController(currentPlayer);
			lpController.setLegendEnable(true);
		}
	}
	
	public GameEngine()
	{
		startMainMenu();
	}
	
	/**
	 * Start to play
	 */
	public static void startGame()
	{
		gameStauts=GAME_STATE.PLAYING;
	}
	
	/**
	 * get the Winner, if the game over
	 */
	@Override
	public Player getWinner()
	{
		return null;
	}
	///===get and set methods==============///

	public static GAME_STATE getGameStauts()
	{
		return gameStauts;
	}

	public static void setGameStauts(GAME_STATE gameStauts)
	{
		GameEngine.gameStauts = gameStauts;
	}

	public Board getBoardFrame()
	{
		return boardFrame;
	}

	public void setBoardFrame(Board boardFrame)
	{
		this.boardFrame = boardFrame;
	}

	public static Player getPlayerA()
	{
		return playerA;
	}

	public static void setPlayerA(Player playerA)
	{
		GameEngine.playerA = playerA;
	}

	public static Player getPlayerB()
	{
		return playerB;
	}

	public static void setPlayerB(Player playerB)
	{
		GameEngine.playerB = playerB;
	}

	public static Player getCurrentPlayer()
	{
		return currentPlayer;
	}

	public static void setCurrentPlayer(Player currentPlayer)
	{
		GameEngine.currentPlayer = currentPlayer;
	}
	
	public static Piece getCurrentPiece()
	{
		return currentPiece;
	}

	public static void setCurrentPiece(Piece currentPiece)
	{
		GameEngine.currentPiece = currentPiece;
	}
	
	public static LegendSquare getCurrentLegendSquare()
	{
		return currentLegendSquare;
	}

	public static void setCurrentLegendSquare(LegendSquare currentLegendSquare)
	{
		GameEngine.currentLegendSquare = currentLegendSquare;
	}

	public int getTimerValue()
	{
		return timerValue;
	}

	public void setTimerValue(int timerValue)
	{
		this.timerValue = timerValue;
	}

	public static BoardView getBoardView()
	{
		return boardView;
	}

	public static void setBoardView(BoardView boardView)
	{
		GameEngine.boardView = boardView;
	}
	
	///===get and set methods==============///
	
}

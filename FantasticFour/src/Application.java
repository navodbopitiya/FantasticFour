import controller.GameEngine;

/**
 * this is the main entrance of the application
 */

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Mar 28, 2018
 * Application.java
 * Describe:
 */
public class Application
{
	private static GameEngine gameEngine;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		gameEngine = new GameEngine();
		//gameEngine.startMainMenu();
		gameEngine.initialize("Player A", "Player B", 30);
		gameEngine.openBoardView(gameEngine);
	}

}

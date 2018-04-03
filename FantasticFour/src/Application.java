import controller.GameEngine;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Mar 28, 2018
 * Application.java
 * Describe: this is the main entrance of the application
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

	public static GameEngine getGameEngine()
	{
		return gameEngine;
	}

}

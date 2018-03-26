<<<<<<< HEAD
import controller.GameEngine;
=======
import java.awt.EventQueue;

import javax.swing.JFrame;

import view.Board;
>>>>>>> origin/master

/**
 * 
 */

/**
 * @author Navod Bopitiya
 *
 */
<<<<<<< HEAD
public class Game {
 
=======
public class Game 
{

	private Board frame;

>>>>>>> origin/master
	/**
	 * Launch the application.
	 */
<<<<<<< HEAD
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameEngine gameEngine = new GameEngine();
		gameEngine.startGame();
		
=======
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new Board();
		frame.setBoardPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>>>>>>> origin/master
	}

}

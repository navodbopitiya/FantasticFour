import java.awt.EventQueue;

import javax.swing.JFrame;

import view.Board;

/**
 * 
 */

/**
 * @author Navod Bopitiya
 *
 */
public class Game 
{

	private Board frame;

	/**
	 * Launch the application.
	 */
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
	}

}

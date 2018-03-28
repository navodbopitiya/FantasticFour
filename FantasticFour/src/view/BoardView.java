/**
 * 
 */
package view;

import java.awt.EventQueue;

import controller.GameEngine;


public class BoardView 
{
	private Board boardFrame;
	
	private GameEngine gameEngine;

	public BoardView(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
		this.boardFrame = gameEngine.getBoardFrame();
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	
	{
		//TODO- remove test print
		System.out.println("You are in initialize -BoardView");
		System.out.println(gameEngine.getPlayerA().getPlayername());
		System.out.println(gameEngine.getPlayerB().getPlayername());
	}
	
	public void display()
	{
		System.out.println("You are in run -BoardView");
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					boardFrame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}

/**
 * 
 */
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.GameEngine;
import view.Board;


public class BoardView {
	
	private Board frame;
	private GameEngine gameEngine;

	public BoardView(GameEngine gameEngine){
		this.gameEngine = gameEngine;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	
	{
		System.out.println("You are in initialize -BoardView"); //TODO- remove test print
		frame = new Board();
		frame.setBoardPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run(){
		System.out.println("You are in run -BoardView"); //TODO- remove test print
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try 
				{
					
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

}

/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import model.Board;
import model.GameConstants;
import model.Piece;
import model.Square;
import controller.GameEngine;


public class BoardView 
{
	private Board boardFrame;
	
	private GameEngine gameEngine;

	/*Constructor*/
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
		System.out.println("You are in initialize -BoardView");
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
	
	public void highLightMoveScope(ArrayList<Square> argSquares)
	{
		Square[][] board_squares = boardFrame.getBoardPanel().getSquares();
		int numOfW = GameConstants.NUMBER_OF_BOARD_SQUARE;
		int numOfH = GameConstants.NUMBER_OF_BOARD_SQUARE;
		for (int i=0;i<numOfW; i++)
		{
			for(int j=0;j<numOfH; j++)
			{
				Piece piece = board_squares[i][j].getPiece();
				if (piece == null)
				{
					if ((i + j) % 2 != 0)
					{
						board_squares[i][j].setBackground(Color.BLACK);
					} else
					{
						board_squares[i][j].setBackground(Color.WHITE);
					}
				}
				for(int k=0; k<argSquares.size(); k++)
				{
					if (i==argSquares.get(k).getPositionX() && j==argSquares.get(k).getPositionY())
					{
						board_squares[i][j].setBackground(Color.GREEN);
					}
				}
			}
		}
	}

}

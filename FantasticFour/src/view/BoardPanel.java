package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.GameConstants;

public class BoardPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private static int boardWidth = 0;
	
	private static int boardHeight = 0;

	public BoardPanel()
	{
		BoardPanel.boardWidth  = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		BoardPanel.boardHeight = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.setBounds(0, GameConstants.SIZE_OF_SQUARE, boardWidth, boardHeight);
		this.setBackground(Color.CYAN);
	}

	public static int getBoardWidth()
	{
		return boardWidth;
	}

	public static int getBoardHeight()
	{
		return boardHeight;
	}

}

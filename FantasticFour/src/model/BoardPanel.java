package model;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoardPanel extends JPanel implements IBoardPanel
{
	private int boardWidth = 0;
	
	private int boardHeight = 0;
	
	private Square[][] squares;

	public BoardPanel()
	{
		this.boardWidth  = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.boardHeight = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.squares = new Square[GameConstants.NUMBER_OF_BOARD_SQUARE][GameConstants.NUMBER_OF_BOARD_SQUARE];
	}

	public int getBoardWidth()
	{
		return boardWidth;
	}

	public void setBoardWidth(int boardWidth)
	{
		this.boardWidth = boardWidth;
	}

	public int getBoardHeight()
	{
		return boardHeight;
	}

	public void setBoardHeight(int boardHeight)
	{
		this.boardHeight = boardHeight;
	}

	public Square[][] getSquares()
	{
		return squares;
	}

	public void setSquares(Square[][] squares)
	{
		this.squares = squares;
	}

}

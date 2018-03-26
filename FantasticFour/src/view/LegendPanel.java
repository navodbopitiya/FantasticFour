package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.GameConstants;
import model.GameConstants.PLAYER_SIDE;
import model.Player;

public class LegendPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private Player player;
	
	private PLAYER_SIDE sidePosition;
	
	private int legendWidth;
	
	private int boardWidth;
	
	public LegendPanel(Player argPlayer)
	{
		this.player = argPlayer;
		this.sidePosition = argPlayer.getSidePosition();
		this.boardWidth = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.legendWidth = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_LEGEND_SQUARE;
		int x = (boardWidth/2) - (legendWidth/2);
		int y = 0;
		if (this.sidePosition == PLAYER_SIDE.NORTH)
		{
			y = 0;
			this.setBackground(Color.BLACK);
		}else
		{
			y = legendWidth + boardWidth;
			this.setBackground(Color.RED);
		}
		//set this panel x,y positon and width and height
		this.setBounds(x, y, legendWidth, legendWidth);
	}

	public Player getPlayer()
	{
		return player;
	}

	public PLAYER_SIDE getSidePosition()
	{
		return sidePosition;
	}

	public int getLegendWidth()
	{
		return legendWidth;
	}

	public int getBoardWidth()
	{
		return boardWidth;
	}
	
}

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import model.GameConstants;
import model.GameConstants.PLAYER_SIDE;
import model.LegendSquare;
import model.Player;

public class LegendPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private Player player;
	
	private PLAYER_SIDE sidePosition;
	
	private int boardWidth;
	
	private int boardHeight;
	
	private int legendWidth;
	
	private int legendHeight;
	
	private LegendSquare[] legendSquares;
	
	public LegendPanel(Player argPlayer)
	{
		this.player = argPlayer;
		this.legendSquares = new LegendSquare[GameConstants.NUMBER_OF_LEGEND_SQUARE];
		this.sidePosition = argPlayer.getSidePosition();
		this.boardWidth  = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.boardHeight = GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_BOARD_SQUARE;
		
		//this.legendWidth = (GameConstants.SIZE_OF_SQUARE * GameConstants.NUMBER_OF_LEGEND_SQUARE) 
		//		+ GameConstants.LENGTH_OF_NAME + 50;
		this.legendWidth = this.boardWidth;
		
		this.legendHeight= GameConstants.SIZE_OF_SQUARE;
		
		int x = (boardWidth/2) - (legendWidth/2);
		int y = 0;
		if (this.sidePosition == PLAYER_SIDE.NORTH)
		{
			y = 0;
		}else
		{
			y = legendHeight + boardHeight;
		}
		this.setBackground(Color.WHITE);
		//set this panel x,y positon and width and height
		this.setBounds(x, y, legendWidth, legendHeight);
		//FlowLayout flowLayout = (FlowLayout) this.getLayout();
		//flowLayout.setAlignment(FlowLayout.CENTER);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 1));
	}
	
	public void addNameLabel()
	{
		JLabel lblPlayerA = new JLabel(player.getPlayername());
		lblPlayerA.setBorder(new LineBorder(new Color(0, 0, 0)));
		if (player.getSidePosition() == PLAYER_SIDE.NORTH)
		{
			lblPlayerA.setForeground(Color.RED);
		}else
		{
			lblPlayerA.setForeground(Color.BLUE);
		}
		lblPlayerA.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerA.setPreferredSize(new Dimension(GameConstants.LENGTH_OF_NAME, this.legendHeight));
		this.add(lblPlayerA);
	}
	
	public void addLegendPiece(LegendSquare ls)
	{
		ls.setPreferredSize(new Dimension(GameConstants.SIZE_OF_SQUARE, GameConstants.SIZE_OF_SQUARE));
		for(int i=0;i<legendSquares.length;i++)
		{
			if (legendSquares[i] == null)
			{
				legendSquares[i] = ls;
				break;
			}
		}
		this.add(ls);
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

	public LegendSquare[] getLegendSquares()
	{
		return legendSquares;
	}
	
}

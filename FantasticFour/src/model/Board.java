/**
 * 
 */
package model;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import controller.BoardPanelController;
import controller.GameEngine;
import controller.LegendPanelController;
import model.GameConstants.PLAYER_SIDE;

/**
 * This is board class which contains BoardPanel and two Player LegenPanels
 * 
 * @author Jason.Zhuang
 * @studentId s3535252 Mar 26, 2018 Board.java Describe:
 */
public class Board extends JFrame
{
	private static final long serialVersionUID = 1L;

	private int boardWidth = 0;

	private int boardHeight = 0;

	private LegendPanel legendPanelA;
	
	private LegendPanel legendPanelB;
	
	private BoardPanel boardPanel;

	// Direction: NORTH, SOUTH, EAST, WEST
	// change the coordinate according to the direction selected

	public Board()
	{
		this.setTitle("OOSD Assignment");
		this.boardWidth = GameConstants.SIZE_OF_SQUARE
				* GameConstants.NUMBER_OF_BOARD_SQUARE + 200;
		this.boardHeight = GameConstants.SIZE_OF_SQUARE
				* GameConstants.NUMBER_OF_BOARD_SQUARE
				+ (GameConstants.SIZE_OF_SQUARE * 2) + 150;
		this.setSize(boardWidth, boardHeight);
		this.getContentPane().setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public void setBoardPanel()
	{
		BoardPanelController bpController = new BoardPanelController();
		this.boardPanel = bpController.initPanel();
		this.getContentPane().add(boardPanel);
	}

	public void setLegendPanel(Player argPlayer)
	{
		LegendPanelController lgC = new LegendPanelController(argPlayer);
		LegendPanel legendPanel = lgC.initPanel();
		argPlayer.setLegendPanel(legendPanel);
		
		if (argPlayer == GameEngine.getCurrentPlayer())
		{
			legendPanel.getLblPlayerName().setText("*" + argPlayer.getPlayername() + "*");
		}
		
		if (argPlayer.getSidePosition() == PLAYER_SIDE.NORTH)
		{
			this.legendPanelA = legendPanel;
		}
		
		if (argPlayer.getSidePosition() == PLAYER_SIDE.SOUTH)
		{
			this.legendPanelB = legendPanel;
		}
			
		this.getContentPane().add(legendPanel);
	}

	
	
	//========================================//
	public LegendPanel getLegendPanelA()
	{
		return legendPanelA;
	}

	public void setLegendPanelA(LegendPanel legendPanelA)
	{
		this.legendPanelA = legendPanelA;
	}

	public LegendPanel getLegendPanelB()
	{
		return legendPanelB;
	}

	public void setLegendPanelB(LegendPanel legendPanelB)
	{
		this.legendPanelB = legendPanelB;
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

	public BoardPanel getBoardPanel()
	{
		return boardPanel;
	}

	public void setBoardPanel(BoardPanel boardPanel)
	{
		this.boardPanel = boardPanel;
	}
	
}

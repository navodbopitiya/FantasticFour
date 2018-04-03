/**
 * 
 */
package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import model.GameConstants;
import model.GameConstants.PLAYER_SIDE;
import model.Player;
import model.Square;
import controller.BoardPanelController;
import controller.GameEngine;
import controller.LegendPanelController;

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

	private Square[][] squares;

	private LegendPanel legendPanelA;
	
	private LegendPanel legendPanelB;

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
		bpController.initBoardPanel();
		BoardPanel bp = bpController.getBoard_panel(); 
		this.squares  = bp.getSquares(); 
		this.getContentPane().add(bp);
	}

	public void setLegendPanel(Player argPlayer)
	{
		LegendPanelController lgC = new LegendPanelController(argPlayer);
		LegendPanel legendPanel = lgC.getLegendPanel();
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
	public Square[][] getSquares()
	{
		return squares;
	}

	public void setSquares(Square[][] squares)
	{
		this.squares = squares;
	}

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
	

}

/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.GameConstants;
import model.GameConstants.PLAYER_SIDE;
import model.LegendSquare;
import model.Player;
import model.Soldier;
import model.Square;

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
	
	int numberOfX = GameConstants.NUMBER_OF_BOARD_SQUARE;

	int numberOfY = GameConstants.NUMBER_OF_BOARD_SQUARE;

	// Direction: NORTH, SOUTH, EAST, WEST
	// change the coordinate according to the direction selected

	public Board()
	{
		this.setTitle("OOSD Assignment");
		this.boardWidth = GameConstants.SIZE_OF_SQUARE
				* GameConstants.NUMBER_OF_BOARD_SQUARE;
		this.boardHeight = GameConstants.SIZE_OF_SQUARE
				* GameConstants.NUMBER_OF_BOARD_SQUARE
				+ (GameConstants.SIZE_OF_SQUARE * 2) + 30;
		this.squares = new Square[GameConstants.NUMBER_OF_BOARD_SQUARE][GameConstants.NUMBER_OF_BOARD_SQUARE];
		this.setSize(boardWidth, boardHeight);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	public void setBoardPanel()
	{
		BoardPanel board_panel = new BoardPanel();
		board_panel.setLayout(new GridLayout(numberOfX, numberOfY));
		SquareButtonHandler buttonHandler = new SquareButtonHandler();
		for (int i = 0; i < numberOfX; i++)
		{
			for (int j = 0; j < numberOfY; j++)
			{
				squares[i][j] = new Square();
				if ((i + j) % 2 != 0)
				{
					squares[i][j].setBackground(Color.BLACK);
				}
				squares[i][j].addActionListener(buttonHandler);
				board_panel.add(squares[i][j]);
			}
		}
		this.getContentPane().add(board_panel);
	}

	public void setLegendPanel(Player argPlayer)
	{
		LegendPanel legendPanel = new LegendPanel(argPlayer);
		
		LegendButtonHandler buttonHandler = new LegendButtonHandler(argPlayer);
		
		if (argPlayer.getSidePosition() == PLAYER_SIDE.NORTH)
		{
			//first add player name to the legend panel;
			legendPanel.addNameLabel();
			//secod add squares to the legend panel;
			for (int i = 1; i <= GameConstants.NUMBER_OF_LEGEND_SQUARE; i++) 
			{ 
				LegendSquare ls = new LegendSquare(i);
				switch (i)
				{
					case 1:
						//playerA-1
						ls.addPiece(new Soldier(),GameConstants.NUMBER_OF_PIECES_LEGEND);						
						break;
					case 2:
						//playerA-2
						ls.addPiece(new Soldier(),GameConstants.NUMBER_OF_PIECES_LEGEND);
						break;
					case 3:
						//playerA-3
						ls.addPiece(new Soldier(),GameConstants.NUMBER_OF_PIECES_LEGEND);
						break;
					default:
						break;
				}
				ls.addActionListener(buttonHandler);
				legendPanel.addLegendPiece(ls);
			}
			this.legendPanelA = legendPanel;
			this.getContentPane().add(this.legendPanelA);
		}
		
		if (argPlayer.getSidePosition() == PLAYER_SIDE.SOUTH)
		{
			//First add squares to the legend panel;
			for (int i = 1; i <= GameConstants.NUMBER_OF_LEGEND_SQUARE; i++) 
			{ 
				LegendSquare ls = new LegendSquare(i);
				switch (i)
				{
					case 1:
						//playerB-1
						ls.addPiece(new Soldier(),GameConstants.NUMBER_OF_PIECES_LEGEND);						
						break;
					case 2:
						//playerB-2
						ls.addPiece(new Soldier(),GameConstants.NUMBER_OF_PIECES_LEGEND);	
						break;
					case 3:
						//playerB-3
						ls.addPiece(new Soldier(),GameConstants.NUMBER_OF_PIECES_LEGEND);	
						break;
					default:
						break;
				}
				ls.addActionListener(buttonHandler);
				legendPanel.addLegendPiece(ls);
			}
			//Second add player name to the legend panel;
			legendPanel.addNameLabel();
			this.legendPanelB = legendPanel;
			this.getContentPane().add(this.legendPanelB);
		}
	}

	private class SquareButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			for (int i = 0; i < numberOfX; i++)
			{
				for (int j = 0; j < numberOfY; j++)
				{
					if (source == squares[i][j])
					{
						SquareClickForBoard(i, j);
						return;
					}
				}
			}
		}

	}
	
	private class LegendButtonHandler implements ActionListener
	{
		private Player innerPlayer;
		
		public LegendButtonHandler(Player player)
		{
			this.innerPlayer = player;
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			if (innerPlayer.getSidePosition() == PLAYER_SIDE.NORTH)
			{
				LegendSquare[] ls = legendPanelA.getLegendSquares();
				for (int i = 0; i < ls.length; i++)
				{
					if (source == ls[i])
					{
						SquareClickForLegend(i,this.innerPlayer);
						return;
					}
				}
			}
			if (innerPlayer.getSidePosition() == PLAYER_SIDE.SOUTH)
			{
				LegendSquare[] ls = legendPanelB.getLegendSquares();
				for (int i = 0; i < ls.length; i++)
				{
					if (source == ls[i])
					{
						SquareClickForLegend(i,this.innerPlayer);
						return;
					}
				}
			}
		}
		
	}

	private void SquareClickForBoard(int i, int j)
	{
		JOptionPane.showMessageDialog(null, "You click Board (" + i + "," + j
				+ ")","Message", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void SquareClickForLegend(int i,Player player)
	{
		JOptionPane.showMessageDialog(null, "You click(" + i + ", name:" + player.getPlayername()
				+ ")","Message", JOptionPane.PLAIN_MESSAGE);
	}

}

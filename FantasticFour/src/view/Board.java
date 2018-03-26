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
import model.Player;
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
				board_panel.add(squares[i][j]);
				squares[i][j].addActionListener(buttonHandler);
			}
		}
		this.getContentPane().add(board_panel);
	}

	public void setLegendPanel(Player argPlayer)
	{
		/*
		 * int legenNumberOfX = 1; int legenNumberOfY = 3; LegendPanel
		 * legendPanel = new LegendPanel(argPlayer);
		 * 
		 * legendPanel.setLayout(new GridLayout(1, 3)); LegendButtonHandler
		 * buttonHandler = new LegendButtonHandler(); for (int i = 0; i <
		 * numberOfX; i++) { for (int j = 0; j < numberOfY; j++) { squares[i][j]
		 * = new Square(); if ((i + j) % 2 != 0) {
		 * squares[i][j].setBackground(Color.BLACK); }
		 * board_panel.add(squares[i][j]);
		 * squares[i][j].addActionListener(buttonHandler); } }
		 * this.getContentPane().add(legendPanel);
		 */
	}

	private class SquareButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			Object source = e.getSource();
			for (int i = 0; i < numberOfX; i++)
			{
				for (int j = 0; j < numberOfY; j++)
				{
					if (source == squares[i][j])
					{
						SquareClick(i, j);
						return;
					}
				}
			}
		}

	}

	private void SquareClick(int i, int j)
	{
		JOptionPane.showMessageDialog(null, "You click(" + i + "," + j
				+ ")","Message", JOptionPane.PLAIN_MESSAGE);
	}

}

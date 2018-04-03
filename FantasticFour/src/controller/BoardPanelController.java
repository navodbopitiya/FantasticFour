/**
 * 
 */
package controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import model.GameConstants;
import model.GameConstants.GAME_STATE;
import model.GameConstants.PLAYER_SIDE;
import model.LegendSquare;
import model.Piece;
import model.Player;
import model.Square;
import view.BoardPanel;

/**
 * @author Jason.Zhuang
 * @studentId s3535252 Mar 30, 2018 BoardPanelController.java Describe:
 */
public class BoardPanelController
{
	private int numberOfX = GameConstants.NUMBER_OF_BOARD_SQUARE;

	private int numberOfY = GameConstants.NUMBER_OF_BOARD_SQUARE;

	private Square[][] squares;

	private BoardPanel board_panel;
	
	public BoardPanelController()
	{
		this.squares = new Square[GameConstants.NUMBER_OF_BOARD_SQUARE][GameConstants.NUMBER_OF_BOARD_SQUARE];
	}

	public BoardPanel initBoardPanel()
	{
		board_panel = new BoardPanel();
		board_panel.setLayout(new GridLayout(numberOfX, numberOfY));
		SquareButtonHandler buttonHandler = new SquareButtonHandler();
		for (int i = 0; i < numberOfX; i++)
		{
			for (int j = 0; j < numberOfY; j++)
			{
				squares[i][j] = new Square();
				squares[i][j].setPositionX(i);
				squares[i][j].setPositionY(j);
				squares[i][j].setOccupied(false);
				//squares[i][j].setEnabled(false);
				squares[i][j].setPiece(null);
				if ((i + j) % 2 != 0)
				{
					squares[i][j].setBackground(Color.BLACK);
				} else
				{
					squares[i][j].setBackground(Color.WHITE);
				}
				squares[i][j].addActionListener(buttonHandler);
				board_panel.add(squares[i][j]);
			}
		}
		board_panel.setSquares(squares);
		
		return board_panel;
	}

	private class SquareButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Square source = (Square)e.getSource();
			for (int i = 0; i < numberOfX; i++)
			{
				for (int j = 0; j < numberOfY; j++)
				{
					if (source == squares[i][j])
					{
						squareClickForBoard(squares[i][j]);
						return;
					}
				}
			}
		}

	}

	private void squareClickForBoard(Square square)
	{
		Player player = GameEngine.getCurrentPlayer();
		if (GameEngine.getGameStauts()== GAME_STATE.INITIALIZED)
		{
			initBoardPiece(player, square);
		}
		if (GameEngine.getGameStauts()== GAME_STATE.PLAYING)
		{
			playBoardPiece(player, square);
		}
		//System.out.println("==============");
	}
	
	private void initBoardPiece(Player player, Square square)
	{
		int x = square.getPositionX();
		//int y = square.getPositionY();
		
		if (player.getSidePosition() == PLAYER_SIDE.NORTH)
		{
			if ( x > 4)
			{
				return;
			}
		}
		
		if (player.getSidePosition() == PLAYER_SIDE.SOUTH)
		{
			if ( x < 5)
			{
				return;
			}
		}
		
		Piece        piece     = GameEngine.getCurrentPiece();		
		LegendSquare legSquare = GameEngine.getCurrentLegendSquare();
		if (piece != null && legSquare != null)
		{
			LegendPanelController blController = new LegendPanelController(player);
			piece.setPlayer(player);
			if (addPieceToBoardSquare(square, piece) == true)
			{
				blController.removePieceFromSquare(legSquare, piece);
				if (legSquare.getPieces().size()==0)
				{
					player.getLegendSquare().remove(legSquare.getSquareID());
				}
				GameEngine.setCurrentLegendSquare(null);
				GameEngine.setCurrentPiece(null);
			}
		}
	}

	public boolean addPieceToBoardSquare(Square square,Piece piece)
	{
		if (square.isOccupied() == false)
		{
			square.setPiece(piece);
			
			String imag_name = "resources\\" + piece.getName() + ".png";
			ImageIcon piece_icon = new ImageIcon(imag_name);
			square.setIcon(piece_icon);

			square.setOccupied(true);	
			
			GameEngine.getCurrentPlayer().getBoardPieces().put(piece.getId(), piece);
			
			return true;
		}
		return false;
	}
	
	public void removePieceFromSquare(Square square,Piece piece)
	{
		if (square.isOccupied() == true)
		{
			square.setPiece(null);
			square.setIcon(null);
			square.setOccupied(false);			
		}
	}
	
	private void playBoardPiece(Player currentPlayer, Square square)
	{
		PlayerController playController = new PlayerController(currentPlayer,this.board_panel);
		playController.executePlay(square);
	}
	
	//get set methods
	public Square[][] getSquares()
	{
		return squares;
	}

	public void setSquares(Square[][] squares)
	{
		this.squares = squares;
	}

	public BoardPanel getBoard_panel()
	{
		return board_panel;
	}
	
}

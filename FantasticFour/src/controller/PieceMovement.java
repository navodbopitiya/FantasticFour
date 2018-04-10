/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.BoardPanel;
import model.GameConstants;
import model.Piece;
import model.Square;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Apr 4, 2018
 * PiceMovement.java
 * Describe:
 */
public class PieceMovement
{
	private Square currentSquare;

	public PieceMovement()
	{
		;
	}

	public Square getCurrentSquare()
	{
		return currentSquare;
	}

	public void setCurrentSquare(Square currentSquare)
	{
		this.currentSquare = currentSquare;
	}

	public void move(Square source, Square target)
	{
		source.getPiece().move(source, target);
	}
	
	protected ArrayList<Square> getAvalaibleMovements(BoardPanel board_panel)
	{
		ArrayList<Square> retValue = new ArrayList<Square>();
		Square[][] board_squares = board_panel.getSquares();
		int x = currentSquare.getPositionX();
		int y = currentSquare.getPositionY();
		int newX = 0;
		int newY = 0;
		Piece piece = currentSquare.getPiece();
		int[] directions = piece.getMoveDirections();
		int maxSteps = piece.getMoveMax();
		
		for(int i=0;i< directions.length;i++)
		{
			switch (directions[i])
			{
				case 1:
					newX = x - 1;
					newY = y - 1;
					if ( newX <0 || newY<0 )
					{
						break;
					}else
					{
						if (board_squares[newX][newY].isOccupied())
						{
							break;
						}else
						{
							Square s = new Square();
							s.setPositionX(newX);
							s.setPositionY(newY);
							retValue.add(s);
						}
					}
					break;
				case 2:
					newX = x;
					newY = y;
					for(int j=0;j<maxSteps;j++)
					{
						newY = newY - 1;
						if (newY <0)
						{
							break;
						}else
						{
							if (board_squares[newX][newY].isOccupied())
							{
								break;
							}else
							{
								Square s = new Square();
								s.setPositionX(newX);
								s.setPositionY(newY);
								retValue.add(s);
							}
						}
					}
					break;
				case 3:
					newX = x + 1;
					newY = y - 1;
					if ( newX >= GameConstants.NUMBER_OF_BOARD_SQUARE || newY< 0 )
					{
						break;
					}else
					{
						if (board_squares[newX][newY].isOccupied())
						{
							
						}else
						{
							Square s = new Square();
							s.setPositionX(newX);
							s.setPositionY(newY);
							retValue.add(s);
						}
					}
					break;
				case 4:
					newX = x;
					newY = y;
					for(int j=0;j<maxSteps;j++)
					{
						newX = newX + 1;
						if (newX >= GameConstants.NUMBER_OF_BOARD_SQUARE)
						{
							break;
						}else
						{
							if (board_squares[newX][newY].isOccupied())
							{
								break;
							}else
							{
								Square s = new Square();
								s.setPositionX(newX);
								s.setPositionY(newY);
								retValue.add(s);
							}
						}
					}
					break;
				case 5:
					newX = x + 1;
					newY = y + 1;
					if ( newX >= GameConstants.NUMBER_OF_BOARD_SQUARE || newY >= GameConstants.NUMBER_OF_BOARD_SQUARE )
					{
						break;
					}else
					{
						if (board_squares[newX][newY].isOccupied())
						{
							break;
						}else
						{
							Square s = new Square();
							s.setPositionX(newX);
							s.setPositionY(newY);
							retValue.add(s);
						}
					}
					break;
				case 6:
					newX = x;
					newY = y;
					for(int j=0;j<maxSteps;j++)
					{
						newY = newY + 1;
						if (newY >= GameConstants.NUMBER_OF_BOARD_SQUARE)
						{
							break;
						}else
						{
							if (board_squares[newX][newY].isOccupied())
							{
								break;
							}else
							{
								Square s = new Square();
								s.setPositionX(newX);
								s.setPositionY(newY);
								retValue.add(s);
							}
						}
					}
					break;
				case 7:
					newX = x - 1;
					newY = y + 1;
					if ( newX < 0 || newY >= GameConstants.NUMBER_OF_BOARD_SQUARE )
					{
						break;
					}else
					{
						if (board_squares[newX][newY].isOccupied())
						{
							break;
						}else
						{
							Square s = new Square();
							s.setPositionX(newX);
							s.setPositionY(newY);
							retValue.add(s);
						}
					}
					break;
				case 8:
					newX = x;
					newY = y;
					for(int j=0;j<maxSteps;j++)
					{
						newX = newX - 1;
						if (newX < 0)
						{
							break;
						}else
						{
							if (board_squares[newX][newY].isOccupied())
							{
								break;
							}else
							{
								Square s = new Square();
								s.setPositionX(newX);
								s.setPositionY(newY);
								retValue.add(s);
							}
						}
					}
					break;

				default:
					break;
			}
		}
		
		return retValue;
	}
	
}

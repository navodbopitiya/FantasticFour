/**
 * 
 */
package controller;

import java.awt.Color;
import java.util.ArrayList;

import model.BoardPanel;
import model.GameConstants;
import model.Piece;
import model.Player;
import model.Square;
import view.BoardView;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Mar 30, 2018
 * PlayerController.java
 * Describe:
 */
public class PlayerController
{
	private GameEngine gameEngine;
	
	private BoardPanel board_panel;
	
	private Player player;
	
	private static Square currentSquare;
	
	private static ArrayList<Square> avaliableMovements;
	
	public PlayerController(Player player,BoardPanel board_panel)
	{
		this.player = player;
		this.board_panel = board_panel;
	}
	
	public void executePlay(Square arg_square)
	{
		//int x = square.getPositionX();
		//int y = square.getPositionY();
		boolean occupy = arg_square.isOccupied();
		Piece  piece   = arg_square.getPiece();
		Player piecePlayer = piece==null?null:piece.getPlayer();
		
		if (occupy == true)
		{
			//click itself piece
			if (piecePlayer.getPlayername().equals(player.getPlayername()))
			{
				selectPiece(arg_square);
				
			}else
			{
				System.out.println("you clicked opposite piece");
				if (attackPiece(getCurrentSquare(),arg_square) == true)
				{
					getPlayer().setMoved(true);
					GameEngine.changePlayer();
				}
			}
		}else
		{
			for(int i=0;i<avaliableMovements.size();i++)
			{
				Square square_ava = avaliableMovements.get(i);
				if (square_ava.getPositionX() == arg_square.getPositionX() &&
					square_ava.getPositionY() == arg_square.getPositionY())
				{
					if (getCurrentSquare()!=null)
					{
						PieceMovement pm = new PieceMovement();
						pm.setCurrentSquare(getCurrentSquare());
						pm.move(pm.getCurrentSquare(), arg_square);
						getPlayer().setMoved(true);
						GameEngine.changePlayer();
					}
				}
			}
			
			resetBoard();
			
		}
		
	}
	
	/**
	 * @param @pre source must be a Square with a piece
	 * @param @pre target must be a Square without a piece 
	 * @return true or false
	 */
	public boolean movePiece(Square source, Square target)
	{
		target.setPiece(source.getPiece());
		target.setIcon(source.getIcon());
		target.setOccupied(true);
		//
		source.setIcon(null);
		source.setPiece(null);
		source.setOccupied(false);
		System.out.println("==Move Piece");
		return true;
	}
	
	public Piece selectPiece(Square arg_square)
	{
		setCurrentSquare(arg_square);
		Piece  piece   = arg_square.getPiece();
		int[] directions = piece.getMoveDirections();
		int maxSteps = piece.getMoveMax();
		avaliableMovements = constructMovingSquares(arg_square, directions, maxSteps);
		//highlight Move Directions
		BoardView bv = GameEngine.getBoardView();
		bv.highLightMoveScope(avaliableMovements);
		System.out.println("==Select Piece");
		return piece;
	}
	
	public boolean attackPiece(Square source, Square target)
	{
		System.out.println("==Attack Piece");
		return false;
	}
	
	private ArrayList<Square> constructMovingSquares(Square position, int[] directions, int maxSteps)
	{
		ArrayList<Square> retValue = new ArrayList<Square>();
		Square[][] board_squares = this.board_panel.getSquares();
		int x = position.getPositionX();
		int y = position.getPositionY();
		int newX = 0;
		int newY = 0;
		for(int i=0;i<directions.length;i++)
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

	public void resetBoard()
	{
		Square[][] board_squares = getBoard_panel().getSquares();
		int numOfW = GameConstants.NUMBER_OF_BOARD_SQUARE;
		int numOfH = GameConstants.NUMBER_OF_BOARD_SQUARE;
		for (int i=0;i<numOfW; i++)
		{
			for(int j=0;j<numOfH; j++)
			{
				if (board_squares[i][j].isOccupied() == true)
				{
					continue;
				}else
				{
					if ((i + j) % 2 != 0)
					{
						board_squares[i][j].setBackground(Color.BLACK);
					} else
					{
						board_squares[i][j].setBackground(Color.WHITE);
					}
				}
			}
		}
		setCurrentSquare(null);
		GameEngine.setCurrentPiece(null);		
	}
	
	public GameEngine getGameEngine()
	{
		return gameEngine;
	}

	public void setGameEngine(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
	}

	public BoardPanel getBoard_panel()
	{
		return board_panel;
	}

	public void setBoard_panel(BoardPanel board_panel)
	{
		this.board_panel = board_panel;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public static Square getCurrentSquare()
	{
		return currentSquare;
	}

	public static void setCurrentSquare(Square currentSquare)
	{
		PlayerController.currentSquare = currentSquare;
	}

	public static ArrayList<Square> getAvaliableMovements()
	{
		return avaliableMovements;
	}

	public static void setAvaliableMovements(ArrayList<Square> avaliableMovements)
	{
		PlayerController.avaliableMovements = avaliableMovements;
	}
	
	
}

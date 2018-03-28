/**
 * 
 */
package model;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Mar 27, 2018
 * LegendSquare.java
 * Describe:
 */
public class LegendSquare extends JButton
{
	private static final long serialVersionUID = -8422737525395379963L;

	private int squareID = 0;
	
	private Piece[] pieces = new Piece[GameConstants.NUMBER_OF_PIECES_LEGEND];
	
	public LegendSquare(int id)
	{
		this.squareID = id;
		this.setBackground(Color.ORANGE);
	}
	
	public void addPiece(Piece piece,int num)
	{
		if ( num > GameConstants.NUMBER_OF_PIECES_LEGEND )
		{
			return;
		}
		for (int i=0;i<num; i++)
		{
			if (pieces[i] == null)
			{
				pieces[i] = piece;
				break;
			}
		}
	}

	public Piece[] getPieces()
	{
		return pieces;
	}

	public int getSquareID()
	{
		return squareID;
	}
	
}

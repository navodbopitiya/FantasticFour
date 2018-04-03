/**
 * 
 */
package model;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

/**
 * @author Jason.Zhuang
 * @studentId s3535252 
 * Mar 27, 2018 
 * LegendSquare.java 
 * Describe:
 */
@SuppressWarnings("serial")
public class LegendSquare extends JButton
{
	private int squareID = 0;

	private ArrayList<Piece> pieces = new ArrayList<Piece>();

	public LegendSquare(int id)
	{
		this.squareID = id;
		this.setPreferredSize(
				new Dimension(GameConstants.SIZE_OF_SQUARE + 10,
				GameConstants.SIZE_OF_SQUARE + 10));
		this.setBackground(null);
	}

	public ArrayList<Piece> getPieces()
	{
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces)
	{
		this.pieces = pieces;
	}

	public int getSquareID()
	{
		return squareID;
	}

}

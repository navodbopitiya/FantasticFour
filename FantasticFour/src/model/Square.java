/**
 * 
 */
package model;

import java.awt.Dimension;

import javax.swing.JButton;

/**
 * The basic Square of the board
 * 
 * @author Jason.Zhuang
 * @studentId s3535252 Mar 28, 2018 Square.java Describe:
 */
@SuppressWarnings("serial")
public class Square extends JButton
{
	private int positionX, positionY;

	private boolean occupied;

	private Piece piece;

	public Square()
	{
		this.setPreferredSize(new Dimension(
				GameConstants.SIZE_OF_SQUARE,
				GameConstants.SIZE_OF_SQUARE));
	}

	public int getPositionX()
	{
		return positionX;
	}

	public void setPositionX(int positionX)
	{
		this.positionX = positionX;
	}

	public int getPositionY()
	{
		return positionY;
	}

	public void setPositionY(int positionY)
	{
		this.positionY = positionY;
	}

	public boolean isOccupied()
	{
		return occupied;
	}

	public void setOccupied(boolean occupied)
	{
		this.occupied = occupied;
	}

	public Piece getPiece()
	{
		return piece;
	}

	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}

}

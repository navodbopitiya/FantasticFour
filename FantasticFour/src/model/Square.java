/**
 * 
 */
package model;

import javax.swing.JButton;

/**
 * The basic Square of the board
 * @author Jason.Zhuang
 * @studentId s3535252
 * Mar 28, 2018
 * Square.java
 * Describe:
 */
public class Square extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int positionX, positionY;
	
	private boolean occupied;
	
	public int getPositionX() 
	{
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
 
	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public void draw(){
		
	}
}

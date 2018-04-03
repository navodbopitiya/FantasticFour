package model;

public class GameConstants
{
	public static int SIZE_OF_SQUARE   = 50;
	
	public static int NUMBER_OF_BOARD_SQUARE = 10;
	
	public static int NUMBER_OF_LEGEND_SQUARE = 3;
	
	/**
	 * how many pieces are there in one category 
	 */
	public static int NUMBER_OF_PIECES_LEGEND = 2;
	
	public static enum GAME_STATE
	{
		INITIALIZED, PLAYING, PAUSED, GAMEOVER
	}
	
	public static enum PLAYER_SIDE
	{
		NORTH, SOUTH
	}
	
	public static int LENGTH_OF_NAME = 200;
	
}

/**
 * 
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import model.Crasher;
import model.GameConstants;
import model.GameConstants.GAME_STATE;
import model.GameConstants.PLAYER_SIDE;
import model.LegendSquare;
import model.Machinist;
import model.Marine;
import model.Piece;
import model.Player;
import model.Soldier;
import model.SpatialController;
import model.Witcher;
import view.LegendPanel;

/**
 * @author Jason.Zhuang
 * @studentId s3535252
 * Mar 30, 2018
 * BoardLegendController.java
 * Describe:
 */
public class LegendPanelController
{
	private LegendPanel legendPanel;
	
	private Player player;
	
	public LegendPanelController(Player player)
	{
		this.player = player;
	}
	
	public void addPieceToSquare(LegendSquare square,Piece piece)
	{
		String imag_name = "resources\\" + piece.getName() + ".png";
		ImageIcon piece_icon = new ImageIcon(imag_name);
		square.setIcon(piece_icon);
		square.getPieces().add(piece);
		int sz = square.getPieces().size();
		String txt = sz + "/" + GameConstants.NUMBER_OF_PIECES_LEGEND;
		
		TitledBorder titleBorder = new TitledBorder(
				UIManager.getBorder("TitledBorder.border"), txt,
				TitledBorder.RIGHT, TitledBorder.CENTER, null,
				Color.DARK_GRAY);
		square.setBorder(titleBorder);
		
		square.setEnabled(false);
	}
	
	public void removePieceFromSquare(LegendSquare square,Piece piece)
	{
		ArrayList<Piece> pieces = square.getPieces();
		int sz = 0;
		if (pieces!=null)
		{
			sz = pieces.size();
		}else
		{
			return;
		}
		
		if (pieces.size()>0)
		{
			for(int i=0; i<sz; i++)
			{
				if (pieces.get(i)== piece)
				{
					square.getPieces().remove(i);
					
					String txt = square.getPieces().size() + "/"
							+ GameConstants.NUMBER_OF_PIECES_LEGEND;
					
					TitledBorder titleBorder = new TitledBorder(
							UIManager.getBorder("TitledBorder.border"), txt,
							TitledBorder.RIGHT, TitledBorder.CENTER, null,
							Color.DARK_GRAY);
					
					square.setBorder(titleBorder);
					
					
					if (square.getPieces().size()== 0)
					{
						square.setEnabled(false);
					}
					break;
				}
			}
		}
	}
	
	public LegendPanel getLegendPanel()
	{
		legendPanel = new LegendPanel(player);
		
		LegendButtonHandler buttonHandler = new LegendButtonHandler(player);
		
		int numOfPieces = GameConstants.NUMBER_OF_PIECES_LEGEND;
		
		if (player.getSidePosition() == PLAYER_SIDE.NORTH)
		{
			//first add a GO button
			legendPanel.addButton();
			legendPanel.getBtnGo().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					btnGoClicked(e);
				}
			});
			
			//second add player name to the legend panel;
			legendPanel.addNameLabel();
			
			//third add squares to the legend panel;
			for (int i = 1; i <= GameConstants.NUMBER_OF_LEGEND_SQUARE; i++) 
			{ 
				LegendSquare square = new LegendSquare(i);
				switch (i)
				{
					case 1:
						//playerA-1
						for(int j=1; j<=numOfPieces; j++)
						{
							String id = i+""+j;
							addPieceToSquare(square, new Soldier(id));
						}
						player.getLegendSquare().put(square.getSquareID(), square); 
						break;
					case 2:
						//playerA-2
						for(int j=1; j<=numOfPieces; j++)
						{
							String id = i+""+j;
							addPieceToSquare(square, new Machinist(id));
						}
						player.getLegendSquare().put(square.getSquareID(), square);
						break;
					case 3:
						//playerA-3
						for(int j=1; j<=numOfPieces; j++)
						{
							String id = i+""+j;
							addPieceToSquare(square, new Marine(id));
						}
						player.getLegendSquare().put(square.getSquareID(), square);
						break;
					default:
						break;
				}
				square.addActionListener(buttonHandler);
				legendPanel.addLegendPiece(square);
			}
			
			return legendPanel;
		}
		
		if (player.getSidePosition() == PLAYER_SIDE.SOUTH)
		{
			//First add squares to the legend panel;
			for (int i = 1; i <= GameConstants.NUMBER_OF_LEGEND_SQUARE; i++) 
			{ 
				LegendSquare square = new LegendSquare(i);
				switch (i)
				{
					case 1:
						//playerB-1 
						for(int j=1; j<=numOfPieces; j++)
						{
							String id = i+""+j;
							addPieceToSquare(square, new Witcher(id));
						}
						player.getLegendSquare().put(square.getSquareID(), square);						
						break;
					case 2:
						//playerB-2
						for(int j=1; j<=numOfPieces; j++)
						{
							String id = i+""+j;
							addPieceToSquare(square, new Crasher(id));
						}
						player.getLegendSquare().put(square.getSquareID(), square);	
						break;
					case 3:
						//playerB-3
						for(int j=1; j<=numOfPieces; j++)
						{
							String id = i+""+j;
							addPieceToSquare(square, new SpatialController(id));
						}
						player.getLegendSquare().put(square.getSquareID(), square);	
						break;
					default:
						break;
				}
				square.addActionListener(buttonHandler);
				legendPanel.addLegendPiece(square);
			}
			//Second add player name to the legend panel;
			legendPanel.addNameLabel();
			
			//third add GO button
			legendPanel.addButton();
			legendPanel.getBtnGo().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) 
				{
					btnGoClicked(e);
				}
			});
			
			return legendPanel;
		}
		
		return null;
	}
	
	public void setLegendEnable(Boolean flag)
	{
		LegendSquare[] ls = player.getLegendPanel().getLegendSquares();
		for(int i=0; i<ls.length; i++)
		{
			ls[i].setEnabled(flag);
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
			LegendSquare[] ls = legendPanel.getLegendSquares();
			for (int i = 0; i < ls.length; i++)
			{
				if (source == ls[i])
				{
					squareClickForLegend(ls[i], i,this.innerPlayer);
					return;
				}
			}
		}
	}
	
	private void squareClickForLegend(LegendSquare square,int idx, Player player)
	{
		Player currentPlayer = GameEngine.getCurrentPlayer();
		
		if (!player.getPlayername().equals(currentPlayer.getPlayername()))
		{
			JOptionPane.showMessageDialog(null, "It is not your turn","Message"
					, JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		LegendPanel lp = player.getLegendPanel();
		LegendSquare[] ls = lp.getLegendSquares();
		for (int i=0;i<ls.length;i++)
		{
			if (ls[i] == square)
			{
				ls[i].setBackground(Color.ORANGE);
			}else
			{
				ls[i].setBackground(null);
			}
		}
		
		GameEngine.setCurrentLegendSquare(square);
		GameEngine.setCurrentPiece(square.getPieces().get(0));
		
		
//		JOptionPane.showMessageDialog(null, "You click(" + idx + ", name:" + player.getPlayername()
//				+ ")","Message", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void btnGoClicked(MouseEvent e)
	{
		//Button btn = (Button)e.getSource();
		
		if (GameEngine.getCurrentPlayer() != player)
		{
			JOptionPane.showMessageDialog(null, "It is not your turn.","Message", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		if (GameEngine.getGameStauts() == GAME_STATE.INITIALIZED)
		{
			int numOfPieces = GameConstants.NUMBER_OF_LEGEND_SQUARE * GameConstants.NUMBER_OF_PIECES_LEGEND;

			if (player.getBoardPieces().size() == numOfPieces)
			{
				GameEngine.changePlayer();
			}else
			{
				JOptionPane.showMessageDialog(null, "You havn't placed all pieces.","Message", JOptionPane.PLAIN_MESSAGE);
			}
		}else if (GameEngine.getGameStauts() == GAME_STATE.PLAYING)
		{
			if (player.isMoved() == false)
			{
				int input = JOptionPane.showConfirmDialog(null
						,"You have not moved any piece,do you want to continue?"
						,"Select an Option...", JOptionPane.YES_NO_OPTION);
				if (input == 0)
				{
					GameEngine.changePlayer();
				}else
				{
					return;
				}
			}
		}
	}
	
}

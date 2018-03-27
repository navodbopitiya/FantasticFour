package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.GameEngine;

public class MainMenuView extends JFrame {

	private JFrame frame;
	public static final Pattern PATTERN = Pattern.compile("^\\d+$"); //pattern for numeric inputs
	private GameEngine gameEngine;

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	

	public MainMenuView(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		initialize();
	}

	private void initialize() {
		/*Create new frame*/
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(27, 91, 127));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/* Label for Player One Text Field*/
		JLabel lblPlayerOne = new JLabel("Player One");
		lblPlayerOne.setForeground(Color.ORANGE);
		lblPlayerOne.setFont(new Font("Arial", Font.BOLD, 13));
		lblPlayerOne.setBounds(58, 80, 120, 23);
		frame.getContentPane().add(lblPlayerOne);
		
		/*TextField for Player One*/
		JTextField playerOneTextField = new JTextField();
		playerOneTextField.setBounds(174, 80, 168, 23);
		frame.getContentPane().add(playerOneTextField);
		playerOneTextField.setColumns(10);
		
		/* Label for Player Two Text Field*/
		JLabel lblPlayerTwo = new JLabel("Player Two");
		lblPlayerTwo.setForeground(Color.ORANGE);
		lblPlayerTwo.setFont(new Font("Arial", Font.BOLD, 13));
		lblPlayerTwo.setBounds(58, 120, 120, 23);
		frame.getContentPane().add(lblPlayerTwo);
		
		/*TextField for Player Two*/
		JTextField playerTwoTextField = new JTextField();
		playerTwoTextField.setBounds(174, 120, 168, 23);
		frame.getContentPane().add(playerTwoTextField);
		playerTwoTextField.setColumns(10);
		
		/* Label for TimerText Field*/
		JLabel timerlbl = new JLabel("Round Time (s)");
		timerlbl.setForeground(Color.ORANGE);
		timerlbl.setFont(new Font("Arial", Font.BOLD, 13));
		timerlbl.setBounds(58, 160, 120, 23);
		frame.getContentPane().add(timerlbl);

		/*TextField for Timer*/
		JTextField timerTextField = new JTextField();
		timerTextField.setBounds(174, 160, 168, 23);
		frame.getContentPane().add(timerTextField);
		timerTextField.setColumns(10);
		
		/* Play button action */
		JButton btnPlay = new JButton("Play");
		btnPlay.setBackground(Color.ORANGE);
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (playerOneTextField.getText() != null && playerTwoTextField.getText() != null
						&& timerTextField.getText() != null) { /*Check for null fields */
					if (PATTERN.matcher(timerTextField.getText()).matches()) { /*Check for non-numeric inputs for timer using a pattern*/
						/*Set player and timer data in gameEngine*/
						gameEngine.setPlayerOneName(playerOneTextField.getText());
						gameEngine.setPlayerTwoName(playerTwoTextField.getText());
						gameEngine.setTimerValue(Integer.parseInt(timerTextField.getText()));
						gameEngine.printText();
					}

				}
				
			}

		});
		btnPlay.setBounds(174, 210, 79, 23);
		frame.getContentPane().add(btnPlay);

	}

}

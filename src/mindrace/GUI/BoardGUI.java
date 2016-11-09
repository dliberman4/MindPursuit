package mindrace.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.LineBorder;

import mindrace.model.Category;
import mindrace.model.Player;
import mindrace.model.Situation;
import mindrace.model.states.ThrowingDice;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

/**
 * @author Agustin Lavarello
 *
 */
public class BoardGUI {

	private JFrame frame;
	private JTextField playerName;
	private ThrowingDice dice;
	private boolean isBtnDicepressed;
	private Situation situation;
	private Player player;
	private Category[] tokens;
	private JButton btnDice;
	private JLabel token_1;
	private JLabel token_2;
	private JLabel token_3;
	private JLabel token_4;
	private JLabel token_5;
	private JLabel token_6;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardGUI window = new BoardGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BoardGUI(//Situation situation 
			) {
		//this.Situation = situation;
		//this.player = situation.getCurrentPlayer();
		//this.tokens = (Category[]) player.getTokens().toArray();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1000,700);
		frame.setResizable(false);
		
		btnDice = new JButton("Tira el dado!!");
		btnDice.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(!isBtnDicepressed) {
					btnDice.setText("");
					ImageIcon dice = null;
					//
					//es de prueba
					Random randomNumber = new Random();
					Integer diceNumber = (int) (randomNumber.nextDouble()*6 + 1); //dice.diceNumber();
					switch (diceNumber) {
					case 1: dice = new ImageIcon("dice1.png");
							break;
					case 2: dice = new ImageIcon("dice2.png"); 
							break;
					case 3: dice = new ImageIcon("dice3.png"); 
							break;
					case 4: dice = new ImageIcon("dice4.png");
							break;
					case 5: dice = new ImageIcon("dice5.png");
							break;
					case 6:	dice = new ImageIcon("dice6.png");
							break;
				}
					btnDice.setIcon(dice);
					isBtnDicepressed = true;
					
			}
		}
		});
		
		playerName = new JTextField();
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setEditable(false);
		playerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		playerName.setText(/*player.getName()*/"");
		playerName.setColumns(10);
		
		JSeparator separator = new JSeparator();
		
		//codigo para escribir que categorias tiene 
		
		token_2 = new JLabel();
		token_3 = new JLabel();
		token_1 = new JLabel();
		token_4 = new JLabel();
		token_6 = new JLabel();
		token_5 = new JLabel();
	
		//player
		/*PlayerGUI playerGUI = new PlayerGUI(new ImageIcon("dice1.png"));
		playerGUI.setX(50);
		playerGUI.setY(50);
		playerGUI.paintComponent(frame.getGraphics());
		
		if(tokens.length >= 1){
			token_1.setText(tokens[0].toString());
		}
		if(tokens.length >= 2){
			token_2.setText(tokens[1].toString());
		}
		if(tokens.length >= 3){
			token_3.setText(tokens[2].toString());
		}
		if(tokens.length >= 4){
			token_4.setText(tokens[3].toString());
		}
		if(tokens.length >= 5){
			token_5.setText(tokens[4].toString());
		}
		if(tokens.length >= 6){
			token_6.setText(tokens[5].toString());
		}
		
     	*/
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 775, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(btnDice, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(token_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(token_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(token_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(token_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(6))
								.addComponent(token_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(playerName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(token_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnDice, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(playerName, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(token_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(token_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(token_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(token_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(token_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(token_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		ImageIcon boardImg = new ImageIcon("board.png");
		JLabel board = new JLabel();
		board.setIcon(boardImg);
		board.setBounds(0, 0, boardImg.getIconWidth(), boardImg.getIconHeight());
		layeredPane.add(board, 0);
		
		frame.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("opciones");
		menuBar.add(mnOptions);
		
		JButton btnSave = new JButton("guardar");
		mnOptions.add(btnSave);
		
		JButton btnExit = new JButton("salir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitWindowGUI exitMenu = new ExitWindowGUI();
				exitMenu.getFrame().setVisible(true);
			}
		});
		mnOptions.add(btnExit);
		
	}
	
	public void setBtnDicepressed(boolean isBtnDicepressed) {
		this.isBtnDicepressed = isBtnDicepressed;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}

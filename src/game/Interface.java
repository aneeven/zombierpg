package game;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
	JFrame frame = new JFrame("Zombie RPG");
	JPanel panelCont = new JPanel();
	JPanel panelStart = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelGame = new JPanel();
	JPanel panelCredits = new JPanel();
	CardLayout cl = new CardLayout();
	private JTextField inputName;

	public Interface() {
		frame.getContentPane().add(panelCont);
		frame.setResizable(false);
		frame.setSize(800, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		panelCont.setLayout(cl);
		panelCont.add(panelStart, "start");
		panelCont.add(panelName, "name");
		panelCont.add(panelGame, "game");
		panelCont.add(panelCredits, "credits");
		cl.show(panelCont, "start");
		
		
		
		// SCREEN: START
		SpringLayout sl_panelStart = new SpringLayout();
		panelStart.setLayout(sl_panelStart);
		panelStart.setBackground(new Color(37, 41, 50));
		
		JButton btnStart = new JButton("Start Game");
		sl_panelStart.putConstraint(SpringLayout.NORTH, btnStart, 180, SpringLayout.NORTH, panelStart);
		sl_panelStart.putConstraint(SpringLayout.SOUTH, btnStart, -212, SpringLayout.SOUTH, panelStart);
		sl_panelStart.putConstraint(SpringLayout.WEST, btnStart, 238, SpringLayout.WEST, panelStart);
		sl_panelStart.putConstraint(SpringLayout.EAST, btnStart, -248, SpringLayout.EAST, panelStart);
		panelStart.add(btnStart);
		
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "name");
			}
		});
		
		JButton btnCredits = new JButton("Credits");
		sl_panelStart.putConstraint(SpringLayout.WEST, btnCredits, 238, SpringLayout.WEST, panelStart);
		sl_panelStart.putConstraint(SpringLayout.EAST, btnCredits, -248, SpringLayout.EAST, panelStart);
		panelStart.add(btnCredits);
		
		btnCredits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "credits");
			}
		});
		
		JButton btnExit = new JButton("Exit");
		sl_panelStart.putConstraint(SpringLayout.SOUTH, btnExit, -48, SpringLayout.SOUTH, panelStart);
		sl_panelStart.putConstraint(SpringLayout.SOUTH, btnCredits, -22, SpringLayout.NORTH, btnExit);
		sl_panelStart.putConstraint(SpringLayout.NORTH, btnExit, 344, SpringLayout.NORTH, panelStart);
		sl_panelStart.putConstraint(SpringLayout.WEST, btnExit, 238, SpringLayout.WEST, panelStart);
		sl_panelStart.putConstraint(SpringLayout.EAST, btnExit, -248, SpringLayout.EAST, panelStart);
		panelStart.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel title = new JLabel ("Zombie RPG");
		title.setForeground(new Color(204, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panelStart.putConstraint(SpringLayout.SOUTH, title, -318, SpringLayout.SOUTH, panelStart);
		sl_panelStart.putConstraint(SpringLayout.NORTH, btnCredits, 126, SpringLayout.SOUTH, title);
		sl_panelStart.putConstraint(SpringLayout.WEST, title, 184, SpringLayout.WEST, panelStart);
		title.setFont(new Font("Arial", Font.BOLD, 70));
		panelStart.add(title);
		
		
		
		// SCREEN: Name
		SpringLayout sl_panelName = new SpringLayout();
		panelName.setLayout(sl_panelName);
		panelName.setBackground(new Color(37, 41, 50));
						
		JButton btnStartGame = new JButton("Go!");
		sl_panelName.putConstraint(SpringLayout.SOUTH, btnStartGame, -48, SpringLayout.SOUTH, panelName);
		sl_panelName.putConstraint(SpringLayout.NORTH, btnStartGame, 344, SpringLayout.NORTH, panelName);
		sl_panelName.putConstraint(SpringLayout.WEST, btnStartGame, 238, SpringLayout.WEST, panelName);
		sl_panelName.putConstraint(SpringLayout.EAST, btnStartGame, -248, SpringLayout.EAST, panelName);
		panelName.add(btnStartGame);
		
		inputName = new JTextField();
		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		inputName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		sl_panelName.putConstraint(SpringLayout.WEST, inputName, 0, SpringLayout.WEST, btnStartGame);
		sl_panelName.putConstraint(SpringLayout.NORTH, inputName, 180, SpringLayout.NORTH, panelName);
		sl_panelName.putConstraint(SpringLayout.SOUTH, inputName, -212, SpringLayout.SOUTH, panelName);
		sl_panelName.putConstraint(SpringLayout.WEST, inputName, 238, SpringLayout.WEST, panelName);
		sl_panelName.putConstraint(SpringLayout.EAST, inputName, -248, SpringLayout.EAST, panelName);
		panelName.add(inputName);
		inputName.setColumns(10);
						
		btnStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "game");
				
			}
		});
		
				
				
		// SCREEN: Game
		SpringLayout sl_panelGame = new SpringLayout();
		panelGame.setLayout(sl_panelGame);
		panelGame.setBackground(new Color(37, 41, 50));
		
		JButton btnSecond = new JButton("Switch to first panel/workspace");
		sl_panelGame.putConstraint(SpringLayout.NORTH, btnSecond, 145, SpringLayout.NORTH, panelGame);
		sl_panelGame.putConstraint(SpringLayout.EAST, btnSecond, -254, SpringLayout.EAST, panelGame);
		panelGame.add(btnSecond);
		
		btnSecond.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "start");
			}
		});
	
		

		// SCREEN: Credits
		SpringLayout sl_panelCredits = new SpringLayout();
		panelCredits.setLayout(sl_panelCredits);
		panelCredits.setBackground(new Color(37, 41, 50));
		
		JButton btnBackToMenu = new JButton("Back to main menu");
		sl_panelCredits.putConstraint(SpringLayout.SOUTH, btnBackToMenu, -48, SpringLayout.SOUTH, panelCredits);
		sl_panelCredits.putConstraint(SpringLayout.NORTH, btnBackToMenu, 344, SpringLayout.NORTH, panelCredits);
		sl_panelCredits.putConstraint(SpringLayout.WEST, btnBackToMenu, 238, SpringLayout.WEST, panelCredits);
		sl_panelCredits.putConstraint(SpringLayout.EAST, btnBackToMenu, -248, SpringLayout.EAST, panelCredits);
		panelCredits.add(btnBackToMenu);
		
		btnBackToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "start");
				
				String playerName = inputName.getText();
				Zombie zombie = new Zombie(playerName);
				System.out.println(zombie.getName());
				
			}
		});			
	}
}
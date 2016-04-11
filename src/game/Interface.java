package game;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Interface {
	JFrame frame = new JFrame("Zombie RPG");
	JPanel panelCont = new JPanel();
	JPanel panelStart = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelGame = new JPanel();
	JPanel panelCredits = new JPanel();
	JPanel panelStatus = new JPanel();
	CardLayout cl = new CardLayout();
	private JTextField inputName;
	Zombie zombie;

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
		panelCont.add(panelStatus, "status");
		cl.show(panelCont, "start");
		panelStart.setBackground(new Color(37, 41, 50));
		panelStart.setLayout(null);
		
		JButton btnStart = new JButton("Spiel starten");
		btnStart.setBounds(238, 180, 314, 61);
		panelStart.add(btnStart);
		
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "name");
			}
		});
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(238, 261, 314, 61);
		panelStart.add(btnCredits);
		
		btnCredits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "credits");
			}
		});
		
		JButton btnExit = new JButton("Beenden");
		btnExit.setBounds(238, 344, 314, 61);
		panelStart.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel title = new JLabel ("Zombie RPG");
		title.setBounds(184, 53, 420, 82);
		title.setForeground(new Color(204, 0, 0));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 70));
		panelStart.add(title);

		panelName.setBackground(new Color(37, 41, 50));
		panelName.setLayout(null);
						
		JButton btnStartGame = new JButton("Spiel starten");
		btnStartGame.setBounds(238, 261, 314, 61);
		panelName.add(btnStartGame);
		
		inputName = new JTextField ();
		inputName.setBounds(238, 180, 314, 61);
		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		inputName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panelName.add(inputName);
		inputName.setColumns(10);
		
		JLabel title2 = new JLabel("Zombie RPG");
		title2.setBounds(184, 53, 420, 82);
		title2.setForeground(new Color(204, 0, 0));
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setFont(new Font("Arial", Font.BOLD, 70));
		panelName.add(title2);
						
		btnStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "game");
				
				// Set userName to input content
				// zombie.setName() = inputName.getText();
				zombie = new Zombie(inputName.getText());
				Gamestart Game = new Gamestart();
				try {
					Game.start(zombie);
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		panelGame.setBackground(new Color(37, 41, 50));
		panelGame.setLayout(null);
		
		JButton btnSearch = new JButton("Suche Menschen");
		btnSearch.setBounds(238, 180, 314, 61);
		panelGame.add(btnSearch);
		
		JButton btnStats = new JButton("Status");
		btnStats.setBounds(238, 261, 314, 61);
		panelGame.add(btnStats);
		
		final JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(238, 171, 61, 16);
		
		btnStats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "status");
				lblNewLabel.setText(zombie.getName());
				lblNewLabel.setText(String.valueOf(zombie.getBrainHunger()));
			}
		});
		
		JButton btnExit2 = new JButton("Beenden");
		btnExit2.setBounds(238, 344, 314, 61);
		panelGame.add(btnExit2);
		
		btnExit2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JLabel title3 = new JLabel ("Zombie RPG");
		title3.setBounds(184, 53, 420, 82);
		title3.setForeground(new Color(204, 0, 0));
		title3.setHorizontalAlignment(SwingConstants.CENTER);
		title3.setFont(new Font("Arial", Font.BOLD, 70));
		panelGame.add(title3);
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "start");
			}
		});
		panelCredits.setBackground(new Color(37, 41, 50));
		panelCredits.setLayout(null);
		
		JButton btnBackToMenu = new JButton("Zurueck zum Menue");
		btnBackToMenu.setBounds(238, 344, 314, 61);
		panelCredits.add(btnBackToMenu);
		
		JLabel title4 = new JLabel ("Zombie RPG");
		title4.setBounds(184, 53, 420, 82);
		title4.setForeground(new Color(204, 0, 0));
		title4.setHorizontalAlignment(SwingConstants.CENTER);
		title4.setFont(new Font("Arial", Font.BOLD, 70));
		panelCredits.add(title4);
		
		
		panelStatus.setBackground(new Color(37, 41, 50));
		panelStatus.setLayout(null);
		
		JButton btnBackToGame = new JButton("Zurueck zum Spiel");
		btnBackToGame.setBounds(238, 344, 314, 61);
		panelStatus.add(btnBackToGame);
		
		
		panelStatus.add(lblNewLabel);
		
		btnBackToGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "game");
			}
		});
	}
}
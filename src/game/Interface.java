package game;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Interface {
	JFrame frame = new JFrame("Zombie RPG");
	JPanel panelCont = new JPanel();
	JPanel panelStart = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelGame = new JPanel();
	JPanel panelFight = new JPanel();
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
		panelCont.add(panelFight, "fight");
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
		
		JLabel title2 = new JLabel ("Zombie RPG");
		title2.setBounds(184, 53, 420, 82);
		title2.setForeground(new Color(204, 0, 0));
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setFont(new Font("Arial", Font.BOLD, 70));
		panelName.add(title2);
						
		btnStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "game");
				
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
		
		final JLabel lblName = new JLabel();
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblName.setText("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(238, 80, 61, 16);
		
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
				if( new Random().nextDouble() <= 0.7 ){
					cl.show(panelCont, "fight");
//    				Sound foundHuman = new Sound("src/audio/foundHuman.wav");
    				try {
    					
						Fight fight = new Fight(zombie, "zombie");
					} catch (IOException | UnsupportedAudioFileException
							| LineUnavailableException | InterruptedException e) {
						e.printStackTrace();
					}
    			} else {
//    				Sound noHuman = new Sound("src/audio/noHuman.wav");
//    				noHuman.playClip();
    				zombie.setBrainHunger(zombie.getBrainHunger() + 1.0);
    				zombie.setDecay(zombie.getDecay() + 2.0);
//    				noHuman.stopClip();
    			}
			}
		});
		
		
		
		panelCredits.setBackground(new Color(37, 41, 50));
		panelCredits.setLayout(null);
		
		JButton btnBackToMenu = new JButton("Zurueck zum Menue");
		btnBackToMenu.setBounds(238, 344, 314, 61);
		panelCredits.add(btnBackToMenu);
		
		btnBackToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "start");
			}
		});
		
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
		
		
		panelStatus.add(lblName);
		
		JLabel lblDecay = new JLabel();
		lblDecay.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDecay.setText("Verfall: ");
		lblDecay.setForeground(Color.WHITE);
		lblDecay.setBounds(238, 108, 61, 16);
		panelStatus.add(lblDecay);
		
		JLabel lblStrength = new JLabel();
		lblStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStrength.setText("Staerke:");
		lblStrength.setForeground(Color.WHITE);
		lblStrength.setBounds(238, 136, 68, 16);
		panelStatus.add(lblStrength);
		
		JLabel lblHunger = new JLabel();
		lblHunger.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHunger.setText("Hunger: ");
		lblHunger.setForeground(Color.WHITE);
		lblHunger.setBounds(238, 164, 68, 16);
		panelStatus.add(lblHunger);
		
		JLabel lblKilled = new JLabel();
		lblKilled.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilled.setText("Menschen getoetet:");
		lblKilled.setForeground(Color.WHITE);
		lblKilled.setBounds(238, 192, 158, 16);
		panelStatus.add(lblKilled);
		
		final JLabel lblNameValue = new JLabel();
		lblNameValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameValue.setForeground(Color.WHITE);
		lblNameValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNameValue.setBounds(491, 81, 61, 16);
		panelStatus.add(lblNameValue);
		
		final JLabel lblDecayValue = new JLabel();
		lblDecayValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDecayValue.setForeground(Color.WHITE);
		lblDecayValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDecayValue.setBounds(491, 109, 61, 16);
		panelStatus.add(lblDecayValue);
		
		final JLabel lblStrengthValue = new JLabel();
		lblStrengthValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrengthValue.setForeground(Color.WHITE);
		lblStrengthValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStrengthValue.setBounds(484, 137, 68, 16);
		panelStatus.add(lblStrengthValue);
		
		final JLabel lblHungerValue = new JLabel();
		lblHungerValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHungerValue.setForeground(Color.WHITE);
		lblHungerValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHungerValue.setBounds(484, 165, 68, 16);
		panelStatus.add(lblHungerValue);
		
		final JLabel lblKilledValue = new JLabel();
		lblKilledValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledValue.setForeground(Color.WHITE);
		lblKilledValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledValue.setBounds(408, 193, 144, 16);
		panelStatus.add(lblKilledValue);
		
		JLabel lblKilledDouchebags = new JLabel();
		lblKilledDouchebags.setText("- Dummkoepfe:");
		lblKilledDouchebags.setForeground(Color.WHITE);
		lblKilledDouchebags.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledDouchebags.setBounds(238, 220, 144, 16);
		panelStatus.add(lblKilledDouchebags);
		
		JLabel lblKilledCraftsmen = new JLabel();
		lblKilledCraftsmen.setText("- Handwerker:");
		lblKilledCraftsmen.setForeground(Color.WHITE);
		lblKilledCraftsmen.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledCraftsmen.setBounds(238, 248, 144, 16);
		panelStatus.add(lblKilledCraftsmen);
		
		JLabel lblKilledAcademics = new JLabel();
		lblKilledAcademics.setText("- Akademiker:");
		lblKilledAcademics.setForeground(Color.WHITE);
		lblKilledAcademics.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledAcademics.setBounds(238, 276, 144, 16);
		panelStatus.add(lblKilledAcademics);
		
		JLabel lblKilledSoldiers = new JLabel();
		lblKilledSoldiers.setText("- Soldaten:");
		lblKilledSoldiers.setForeground(Color.WHITE);
		lblKilledSoldiers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledSoldiers.setBounds(238, 304, 144, 16);
		panelStatus.add(lblKilledSoldiers);
		
		final JLabel lblKilledDouchebagsValue = new JLabel();
		lblKilledDouchebagsValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledDouchebagsValue.setForeground(Color.WHITE);
		lblKilledDouchebagsValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledDouchebagsValue.setBounds(408, 221, 144, 16);
		panelStatus.add(lblKilledDouchebagsValue);
		
		final JLabel lblKilledCraftsmenValue = new JLabel();
		lblKilledCraftsmenValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledCraftsmenValue.setForeground(Color.WHITE);
		lblKilledCraftsmenValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledCraftsmenValue.setBounds(408, 249, 144, 16);
		panelStatus.add(lblKilledCraftsmenValue);
		
		final JLabel lblKilledAcademicsValue = new JLabel();
		lblKilledAcademicsValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledAcademicsValue.setForeground(Color.WHITE);
		lblKilledAcademicsValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledAcademicsValue.setBounds(408, 277, 144, 16);
		panelStatus.add(lblKilledAcademicsValue);
		
		final JLabel lblKilledSoldiersValue = new JLabel();
		lblKilledSoldiersValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledSoldiersValue.setForeground(Color.WHITE);
		lblKilledSoldiersValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledSoldiersValue.setBounds(408, 305, 144, 16);
		panelStatus.add(lblKilledSoldiersValue);
		
		btnStats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "status");
				lblNameValue.setText(zombie.getName());
				lblDecayValue.setText(String.valueOf(zombie.getDecay()));
				lblStrengthValue.setText(String.valueOf(zombie.getStrength()));
				lblHungerValue.setText(String.valueOf(zombie.getBrainHunger()));
				lblKilledValue.setText(String.valueOf(zombie.getHumansKilled()));
				
				lblKilledDouchebagsValue.setText((String.valueOf(zombie.killedDouchbags)));
				lblKilledCraftsmenValue.setText((String.valueOf(zombie.killedCraftsmen)));
				lblKilledAcademicsValue.setText((String.valueOf(zombie.killedAcademics)));
				lblKilledSoldiersValue.setText((String.valueOf(zombie.killedSoldiers)));
			}
		});
		
		btnBackToGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "game");
			}
		});
		
		panelFight.setBackground(new Color(37, 41, 50));
		panelFight.setLayout(null);
		
		JButton btnKratzen = new JButton("Kratzen");
		btnKratzen.setBounds(45, 300, 117, 53);
		panelFight.add(btnKratzen);
		
		btnKratzen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				attack(human, zombie, 11);
			}
		});
		
		JButton btnEntwaffnen = new JButton("Entwaffnen");
		btnEntwaffnen.setBounds(174, 300, 117, 53);
		panelFight.add(btnEntwaffnen);
//		if(human.hasItem) {
//			attack(human, zombie, 12);
//		} else {
//			System.out.println("Du bist gestolpert...");
//			zombie.setDecay(zombie.getDecay() + 5.0);
//		}
		
		btnEntwaffnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				attack(human, zombie, 11);
			}
		});
		
		JButton btnBeissen = new JButton("Beissen");
		btnBeissen.setBounds(45, 365, 117, 53);
		panelFight.add(btnBeissen);
		
		btnBeissen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				attack(human, zombie, 13);
			}
		});
		
		JButton btnAnspringen = new JButton("Anspringen");
		btnAnspringen.setBounds(174, 365, 117, 53);
		panelFight.add(btnAnspringen);
		
		btnAnspringen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				attack(human, zombie, 14);
			}
		});
		
		JButton btnFlchten = new JButton("Fluechten");
		btnFlchten.setBounds(303, 300, 117, 53);
		panelFight.add(btnFlchten);
		
		btnFlchten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Escape escape = new Escape(zombie, human);
			}
		});
	}
}
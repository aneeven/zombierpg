package game;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Interface
 * 
 * class representing the application window and 
 * controlling the game events
 *
 */
public class Interface {
	JFrame frame = new JFrame("Zombie RPG");
	JPanel panelCont = new JPanel();
	JPanel panelStart = new JPanel();
	JPanel panelName = new JPanel();
	JPanel panelGame = new JPanel();
	JPanel panelFight = new JPanel();
	JPanel panelCredits = new JPanel();
	JPanel panelStatus = new JPanel();
	public CardLayout cl = new CardLayout();
	private JTextField inputName;
	Zombie zombie;
	public Human human;
	Sound backgroundMusic;
	boolean gameloop = false;
	public Fight fight;

	/**
	 * Interface constructor
	 * 
	 * Sets the window size and the game logic
	 */
	public Interface() {
		// frame contains content pane depending on game state
		frame.getContentPane().add(panelCont);
		// disable resizing of the window
		frame.setResizable(false);
		// setting absolute window size, default close operation and visibility
		frame.setSize(800, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// setting card layout to panel
		panelCont.setLayout(cl);
		// add different panels to the content panel
		panelCont.add(panelStart, "start");
		panelCont.add(panelName, "name");
		panelCont.add(panelGame, "game");
		panelCont.add(panelFight, "fight");
		panelCont.add(panelCredits, "credits");
		panelCont.add(panelStatus, "status");
		// setting the starting panel content
		cl.show(panelCont, "start");
		
		// #################################################
		// MAIN MENU
		// #################################################
		
		// set the background music of the game to maintitle
		try {
			this.backgroundMusic = new Sound("audio/title.wav");
		} catch (IOException | UnsupportedAudioFileException
				| LineUnavailableException | InterruptedException e3) {
			e3.printStackTrace();
		}
		
		// setting the start panels' background and layout
		panelStart.setBackground(new Color(37, 41, 50));
		panelStart.setLayout(null);
		
		// button for starting the game
		JButton btnStart = new JButton("Spiel starten");
		btnStart.setBounds(238, 180, 314, 61);
		panelStart.add(btnStart);
		// acion listener for btnStart
		// show new panel content for user input
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "name");
			}
		});
		
		// button for showing credits
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(238, 261, 314, 61);
		panelStart.add(btnCredits);
		// acion listener for btnCredits
		// show new panel content with credits
		btnCredits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "credits");
			}
		});
		
		// button for closing the application
		JButton btnExit = new JButton("Beenden");
		btnExit.setBounds(238, 344, 314, 61);
		panelStart.add(btnExit);
		// action listener for btnExit
		// closes the game
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// #################################################
		// NAME INPUT - instantiation of players' zombie object
		// #################################################
		
		// Main label for game title
		setTitleToContentPane("Zombie RPG", panelStart);

		// setup of the name panel where user can input character name
		panelName.setBackground(new Color(37, 41, 50));
		panelName.setLayout(null);
		
		// setup of the main title of the name panel
		setTitleToContentPane("Zombie RPG", panelName);
		
		// setup of the name input
		inputName = new JTextField ("Bitte Spielernamen eingeben");
		inputName.setBounds(238, 180, 314, 61);
		inputName.setHorizontalAlignment(SwingConstants.CENTER);
		inputName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panelName.add(inputName);
		inputName.setColumns(10);
		
		// button for begin the game
		JButton btnStartGame = new JButton("Spiel starten");
		btnStartGame.setBounds(238, 261, 314, 61);
		panelName.add(btnStartGame);
		// action listener for btnStartGame
		// starts the game with given user input as character name
		btnStartGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameloop = true;
				// switch to game panel content
				cl.show(panelCont, "game");
				// instantiate the players' character with given name
				zombie = new Zombie(inputName.getText());
				// change background music to game music
				try {
					backgroundMusic.stopClip();
					backgroundMusic = new Sound("audio/nature.wav");
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// #################################################
		// GAME MENU
		// #################################################
		
		// setting up the game panel background and layout
		panelGame.setBackground(new Color(37, 41, 50));
		panelGame.setLayout(null);
		
		// setting up the main title of the game content pane
		setTitleToContentPane("Zombie RPG", panelGame);
		
		// creating the button for searching enemies
		JButton btnSearch = new JButton("Suche Menschen");
		btnSearch.setBounds(238, 180, 314, 61);
		panelGame.add(btnSearch);
		
		// creating the button for displaying status
		JButton btnStats = new JButton("Status");
		btnStats.setBounds(238, 261, 314, 61);
		panelGame.add(btnStats);
		
		// creating the button for closing the game
		JButton btnExit2 = new JButton("Beenden");
		btnExit2.setBounds(238, 344, 314, 61);
		panelGame.add(btnExit2);
		
		// action listener for btnExit
		// ends the game and closes application
		btnExit2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		// action listener for btnSearch
		// if successful shows fight panel
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Sound noHuman = null;
				if( new Random().nextDouble() <= 0.7 ){
					// play sound when fight starts
					try {
						Sound foundHuman = new Sound("audio/foundHuman.wav");
					} catch (IOException | UnsupportedAudioFileException
							| LineUnavailableException | InterruptedException e1) {
						e1.printStackTrace();
					}
    				try {
    					cl.show(panelCont, "fight");
    					// start the fight, player beginning
						fight = new Fight(zombie, "zombie");
						human = fight.getHuman();
					} catch (IOException | UnsupportedAudioFileException
							| LineUnavailableException | InterruptedException e) {
						e.printStackTrace();
					}
    			} else {
    				// play sound when no enemy was found
					try {
						noHuman = new Sound("audio/noHuman.wav");
					} catch (IOException | UnsupportedAudioFileException
							| LineUnavailableException | InterruptedException e) {
						e.printStackTrace();
					}
    				try {
						noHuman.playClip();
					} catch (IOException | UnsupportedAudioFileException
							| LineUnavailableException | InterruptedException e) {
						e.printStackTrace();
					}
    				// increasing players' decay and hunger
    				zombie.setBrainHunger(zombie.getBrainHunger() + 1.0);
    				zombie.setDecay(zombie.getDecay() + 2.0);
    				noHuman.stopClip();
    			}
			}
		});
		
		// #################################################
		// CREDITS
		// #################################################
		
		// setting up the credits panel
		panelCredits.setBackground(new Color(37, 41, 50));
		panelCredits.setLayout(null);
		
		// setup the main title for credits panel
		setTitleToContentPane("Zombie RPG", panelCredits);
		
		//add img to Credits panel
        appendImageToPanel("img/zombieOpenHead.png", panelCredits, 50, 100, 200, 200);
		
        // textarea setup: 5-cols 20-rows
        JTextArea creditsText = new JTextArea(5, 20);
        creditsText.setText("ZOMBIE RPG \n, " +
        		"... ein rundenbasiertes Java-Spiel\n\n" +
        		"Der Spieler schlüpft in die Rolle eines Zombies und muss versuchen, Menschen aufzuspüren und zu verspeisen.\n" +
        		"Es gibt vier Gegner-Typen: Dummköpfe, Handwerker, Akademiker und Soldaten. " +
        		"Jede Handlung ist an eine bestimmte Erfolgswahrscheinlichkeit gekoppelt. " +
        		"So ist es beispielsweise sehr unwahrscheinlich, dass ein Dummkopf einen Gegenstand bei sich trägt. " +
        		"Bei Handwerker ist sie hingegen sehr hoch. \n" +
        		"Der Zombie-Charakter des Spielers muss stets auf seinen Hunger und seinen Zerfall achten. " +
        		"Steigt der Zerfall auf 100%, ist es um den Zombie geschehen. Er löst sich in seine Einzelteile auf und das Spiel ist zuende." +
        		"\nAutoren: \n" +
        		"- A.Neeven\n" +
        		"- F.Petruschke\n" +
        		"\nStand: 17.04.2016\n" +
        		"Version: 1.0.0");
        // linebreaks enabled
        creditsText.setLineWrap(true);
        // linebreaks only after full word
        creditsText.setWrapStyleWord(true);
        // scroll to top of the text
        creditsText.setCaretPosition(0);
        //setting up scroll pane
        JScrollPane scrollpane = new JScrollPane(creditsText);
        // setting the textareas size
        scrollpane.setBounds(238, 200, 314, 100);
        panelCredits.add(scrollpane);
        
		// button for going back to menu
		JButton btnBackToMenu = new JButton("Zurück zum Menü");
		btnBackToMenu.setBounds(238, 344, 314, 61);
		panelCredits.add(btnBackToMenu);
		// action listener for btnBackToMenu
		// switches content back to main menu content
		btnBackToMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "start");
			}
		});
		
		// #################################################
		// STATUS
		// #################################################
		
		panelStatus.setBackground(new Color(37, 41, 50));
		panelStatus.setLayout(null);
		
		JButton btnBackToGame = new JButton("Zurück zum Spiel");
		btnBackToGame.setBounds(238, 344, 314, 61);
		panelStatus.add(btnBackToGame);
		
		// name label
		final JLabel lblName = new JLabel();
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblName.setText("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(238, 80, 61, 16);
		panelStatus.add(lblName);
		
		// name value label
		final JLabel lblNameValue = new JLabel();
		lblNameValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNameValue.setForeground(Color.WHITE);
		lblNameValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNameValue.setBounds(491, 81, 61, 16);
		panelStatus.add(lblNameValue);
		
		// decay label
		JLabel lblDecay = new JLabel();
		lblDecay.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDecay.setText("Zerfall: ");
		lblDecay.setForeground(Color.WHITE);
		lblDecay.setBounds(238, 108, 61, 16);
		panelStatus.add(lblDecay);
		
		// decay value label
		final JLabel lblDecayValue = new JLabel();
		lblDecayValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDecayValue.setForeground(Color.WHITE);
		lblDecayValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDecayValue.setBounds(491, 109, 61, 16);
		panelStatus.add(lblDecayValue);
		
		// strength label
		JLabel lblStrength = new JLabel();
		lblStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStrength.setText("Stärke:");
		lblStrength.setForeground(Color.WHITE);
		lblStrength.setBounds(238, 136, 68, 16);
		panelStatus.add(lblStrength);
		
		// strength value label
		final JLabel lblStrengthValue = new JLabel();
		lblStrengthValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrengthValue.setForeground(Color.WHITE);
		lblStrengthValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblStrengthValue.setBounds(484, 137, 68, 16);
		panelStatus.add(lblStrengthValue);
		
		// hunger label
		JLabel lblHunger = new JLabel();
		lblHunger.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHunger.setText("Hunger: ");
		lblHunger.setForeground(Color.WHITE);
		lblHunger.setBounds(238, 164, 68, 16);
		panelStatus.add(lblHunger);
		
		// hunger value label
		final JLabel lblHungerValue = new JLabel();
		lblHungerValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHungerValue.setForeground(Color.WHITE);
		lblHungerValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHungerValue.setBounds(484, 165, 68, 16);
		panelStatus.add(lblHungerValue);
		
		// sum kills label
		JLabel lblKilled = new JLabel();
		lblKilled.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilled.setText("Menschen getötet:");
		lblKilled.setForeground(Color.WHITE);
		lblKilled.setBounds(238, 192, 158, 16);
		panelStatus.add(lblKilled);
		
		// sum kills value label
		final JLabel lblKilledValue = new JLabel();
		lblKilledValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledValue.setForeground(Color.WHITE);
		lblKilledValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledValue.setBounds(408, 193, 144, 16);
		panelStatus.add(lblKilledValue);
		
		// killed douchebags label
		JLabel lblKilledDouchebags = new JLabel();
		lblKilledDouchebags.setText("- Dummköpfe:");
		lblKilledDouchebags.setForeground(Color.WHITE);
		lblKilledDouchebags.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledDouchebags.setBounds(238, 220, 144, 16);
		panelStatus.add(lblKilledDouchebags);
		
		// killed douchebags value label
		final JLabel lblKilledDouchebagsValue = new JLabel();
		lblKilledDouchebagsValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledDouchebagsValue.setForeground(Color.WHITE);
		lblKilledDouchebagsValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledDouchebagsValue.setBounds(408, 221, 144, 16);
		panelStatus.add(lblKilledDouchebagsValue);
		
		// killed craftsmen label
		JLabel lblKilledCraftsmen = new JLabel();
		lblKilledCraftsmen.setText("- Handwerker:");
		lblKilledCraftsmen.setForeground(Color.WHITE);
		lblKilledCraftsmen.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledCraftsmen.setBounds(238, 248, 144, 16);
		panelStatus.add(lblKilledCraftsmen);
		
		// killed craftsmen value label
		final JLabel lblKilledCraftsmenValue = new JLabel();
		lblKilledCraftsmenValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledCraftsmenValue.setForeground(Color.WHITE);
		lblKilledCraftsmenValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledCraftsmenValue.setBounds(408, 249, 144, 16);
		panelStatus.add(lblKilledCraftsmenValue);
		
		// killed academis label
		JLabel lblKilledAcademics = new JLabel();
		lblKilledAcademics.setText("- Akademiker:");
		lblKilledAcademics.setForeground(Color.WHITE);
		lblKilledAcademics.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledAcademics.setBounds(238, 276, 144, 16);
		panelStatus.add(lblKilledAcademics);
		
		// killed academics value label
		final JLabel lblKilledAcademicsValue = new JLabel();
		lblKilledAcademicsValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledAcademicsValue.setForeground(Color.WHITE);
		lblKilledAcademicsValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledAcademicsValue.setBounds(408, 277, 144, 16);
		panelStatus.add(lblKilledAcademicsValue);
		
		// killed soldiers label
		JLabel lblKilledSoldiers = new JLabel();
		lblKilledSoldiers.setText("- Soldaten:");
		lblKilledSoldiers.setForeground(Color.WHITE);
		lblKilledSoldiers.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledSoldiers.setBounds(238, 304, 144, 16);
		panelStatus.add(lblKilledSoldiers);
		
		// killed soldiers value label
		final JLabel lblKilledSoldiersValue = new JLabel();
		lblKilledSoldiersValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKilledSoldiersValue.setForeground(Color.WHITE);
		lblKilledSoldiersValue.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKilledSoldiersValue.setBounds(408, 305, 144, 16);
		panelStatus.add(lblKilledSoldiersValue);
		
		// action listener for btnStatus
		// sets content to players' status
		btnStats.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "status");
				// getting value for labels and their corresponding values
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
		
		// action listener for btnBackToGame
		// switches content back to game content
		btnBackToGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panelCont, "game");
			}
		});
		
		// #################################################
		// ATTACKS
		// #################################################
		
		panelFight.setBackground(new Color(37, 41, 50));
		panelFight.setLayout(null);
		
		appendImageToPanel("img/zombieOpenHead.png", panelFight, 50, 100, 20, 20);
		appendImageToPanel("img/humanFinal.png", panelFight, 50, 100, 200, 20);
		
		JButton btnKratzen = new JButton("Kratzen");
		btnKratzen.setBounds(45, 300, 117, 53);
		panelFight.add(btnKratzen);
		
		btnKratzen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					fight.zombiesAttackChoice(1, zombie, human);
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e) {
					e.printStackTrace();
				}	
			}
		});
		
		/**
		 * @toDo if human hasItem.... check functionality
		 */
		JButton btnEntwaffnen = new JButton("Entwaffnen");
		btnEntwaffnen.setBounds(174, 300, 117, 53);
		panelFight.add(btnEntwaffnen);
		
		btnEntwaffnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					try {
						fight.zombiesAttackChoice(2, zombie, human);
					} catch (IOException | UnsupportedAudioFileException
							| LineUnavailableException | InterruptedException e) {
						e.printStackTrace();
					}
			}
		});
		
		JButton btnBeissen = new JButton("Beissen");
		btnBeissen.setBounds(45, 365, 117, 53);
		panelFight.add(btnBeissen);
		
		btnBeissen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					fight.zombiesAttackChoice(3, zombie, human);
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		JButton btnAnspringen = new JButton("Anspringen");
		btnAnspringen.setBounds(174, 365, 117, 53);
		panelFight.add(btnAnspringen);
		
		btnAnspringen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					fight.zombiesAttackChoice(4, zombie, human);
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		JButton btnFlchten = new JButton("Flüchten");
		btnFlchten.setBounds(303, 300, 117, 53);
		panelFight.add(btnFlchten);
		btnFlchten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Escape escape = new Escape(zombie, human);
				} catch (IOException | UnsupportedAudioFileException
						| LineUnavailableException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * setTitleToContentPane
	 * 
	 * method for setting the main title to jPanels
	 * so they all look the same
	 * 
	 * @param title			Title that should be displayed as maintitle
	 * @param jPanelName	name of the panel the title should be appended to
	 */
	public void setTitleToContentPane(String title, JPanel jPanelName) {
		// setting up the main title of the game content pane
		JLabel maintitle = new JLabel (title);
		maintitle.setBounds(184, 53, 420, 82);
		maintitle.setForeground(new Color(204, 0, 0));
		maintitle.setHorizontalAlignment(SwingConstants.CENTER);
		maintitle.setFont(new Font("Arial", Font.BOLD, 50));
		jPanelName.add(maintitle);
	}
	
	/**
	 * appendImageToPanel
	 * 
	 * Appends an image to an existing JPanel.
	 * Image must be inside a folder of type "source folder" inside the application folder!
	 * 
	 * @param pathToImg			path to the image inside the source folder "images"
	 * @param jpanelForImg		panel to append the image to
	 * @param widthOfImg		width of the image
	 * @param heightOfImg		height of the image
	 * @param absoluteXPos		absolute x position on the panel
	 * @param absoluteYPos		absolute y position on the panel
	 */
	public void appendImageToPanel(String pathToImg, JPanel jpanelForImg, int widthOfImg, int heightOfImg, int absoluteXPos, int absoluteYPos) {
		File f = new File(pathToImg);
		  if(f.exists()){
			  ImageIcon icon = new ImageIcon(pathToImg);
		        Image img = null;
		        try {
		        	img = icon.getImage();
		        } catch(Exception e) {
		        	System.out.println(e.getMessage());
		        }
		        Image newimg = img.getScaledInstance(widthOfImg, heightOfImg,  java.awt.Image.SCALE_SMOOTH);
		        ImageIcon icon2 = new ImageIcon(newimg);
		        JLabel imageLabel = new JLabel(icon2);
		        imageLabel.setBounds(absoluteXPos, absoluteYPos, widthOfImg, heightOfImg);
		        jpanelForImg.add(imageLabel);
		  }else{
			  System.out.println("File not found! Is it located inside src-folder? Check: " + pathToImg);
		  }
	}
}
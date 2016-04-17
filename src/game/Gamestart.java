package game;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

public class Gamestart {
	
	public static String gamestate="startmenu";
	public static boolean music=true;
	public Sound backgroundMusic;
	
	
	/**
	 * main
	 * 
	 * class for startmenu and executing players choices
	 * 
	 * @param args
	 * @throws InterruptedException 
	 * @throws LineUnavailableException 
	 * @throws UnsupportedAudioFileException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

//		new Sound("src/audio/title.wav");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Interface();
				
			}
		});
	}
		
	/**
	 * start
	 * 
	 * Method for starting the actual game.
	 * It gives the user action options to choose from after
	 * instantiating the users' zombie object
	 * 
	 * @param zombie
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 * @throws InterruptedException
	 */
	public void start(Zombie zombie) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
		
			//Zombie zombie = new Zombie("hains");
			gamestate = "mainmenu";
			
			// stop playing background music from main menu
//			backgroundMusic.stopClip();
			
			// start new background title
			// Sound backgroundTheme = new Sound("src/audio/nature.wav");
			
			// showing provisionally Main Menu
//			while(gamestate == "mainmenu") {
//				int choice = 0;
//				
//				// switch case for main menu choices
//				switch (choice) {
//		        	case 1: gamestate = "fight";
//		        			// probability of finding human = 70%
//		        			if( new Random().nextDouble() <= 0.7 ){
//		        				Sound foundHuman = new Sound("src/audio/foundHuman.wav");
//		        				Fight fight = new Fight(zombie, "zombie");
//		        			} else {
//		        				Sound noHuman = new Sound("src/audio/noHuman.wav");
//		        				noHuman.playClip();
//		        				System.out.println("Niemand zu sehen.");
//		        				System.out.println("Hunger und Zerfall steigen...");
//		        				zombie.setBrainHunger(zombie.getBrainHunger() + 1.0);
//		        				zombie.setDecay(zombie.getDecay() + 2.0);
//		        				noHuman.stopClip();
//		        				gamestate = "mainmenu";
//					    		break;
//		        			}
//		                 	break;
//		        	case 2: gamestate = "state";
//				    		gamestate = "mainmenu";
//				    		break;
//		        	case 3: System.exit(0);
//					default:
//							gamestate = "mainmenu";
//							break;
//				}
//			}
		}
	}

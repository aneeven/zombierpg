package game;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 * Start
 * 
 * Main class for starting the game. 
 * 
 * @author f.petruschke
 */
public class Start {

	public static String gamestate="startmenu";
	public static boolean music=true;
	
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

		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Interface();
			}
		});
		
		// playing background music
		Sound backgroundMusic = new Sound("src/audio/title.wav");
		
		while(Start.gamestate == "startmenu") {
			
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			switch(choice) {
				case(1):	
							break;
				case(2):	System.out.println();
							break;
				case(3):	System.exit(0);
							break;
				default:    System.exit(1);
							break;
			}
		}	
	}
}

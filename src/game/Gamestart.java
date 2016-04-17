package game;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 * Gamestart
 * 
 * starts the game
 */
public class Gamestart {
	
	/**
	 * main
	 * 
	 * class for starting the game
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
	}
}

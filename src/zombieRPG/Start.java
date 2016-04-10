package zombieRPG;

import java.util.Scanner;

/**
 * Start
 * 
 * Main class for starting the game. 
 * 
 * @author f.petruschke
 */
public class Start {

	public static String gamestate="startmenu";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		while(Start.gamestate == "startmenu") {
			System.out.println("###############################");
			System.out.println("#     Z O M B I E   R P G     #");
			System.out.println("###############################");
			System.out.println("#                             #");
			System.out.println("#                             #");
			System.out.println("#      [1] Spiel starten      #");
			System.out.println("#      [2] Credits            #");
			System.out.println("#                             #");
			System.out.println("#      [3] Spiel beenden      #");
			System.out.println("#                             #");
			System.out.println("###############################");
			
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			
			switch(choice) {
				case(1): 	clearConsole();
							Start.gamestate = "mainmenu";
							Gamestart Game = new Gamestart();
							Game.start();
							break;
				case(2):	clearConsole();
							showCredits();
							break;
				case(3):	clearConsole();
							System.exit(0);
							break;
				default:    clearConsole();
							System.exit(1);
							break;
			}
		}	
	}
	
	public static void showCredits() {
		System.out.println("###############################");
		System.out.println("#     Z O M B I E   R P G     #");
		System.out.println("#        C R E D I T S        #");
		System.out.println("###############################");
		System.out.println("#                             #");
		System.out.println("#  Das Zombie RPG ist ein     #");
		System.out.println("#  simples rundenbasiertes    #");
		System.out.println("#  RPG - geschrieben in Java. #");
		System.out.println("#                             #");
		System.out.println("#      Autoren:               #");
		System.out.println("#      A. Neeven              #");
		System.out.println("#      F.Petruschke           #");
		System.out.println("#                             #");
		System.out.println("#      [1] zurück             #");
		System.out.println("#                             #");
		System.out.println("###############################");
		
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		switch(choice) {
			case(1): 	Start.gamestate = "startmenu";
						break;
			default:	Start.gamestate = "startmenu";
						break;
		}
	}
	
	public final static void clearConsole() {
	    try {
	        final String os = System.getProperty("os.name");
	        if (os.contains("Windows")) {
	            Runtime.getRuntime().exec("cls");
	        } else {
	            Runtime.getRuntime().exec("clear");
	        }
	    } catch (final Exception e) {
	        System.out.println("Konnte die Ausgabe nicht bereinigen.");
	    }
	}
}

package zombieRPG;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Gamestart {
	
	public static String gamestate="mainmenu";
	
	public static void main(String[] args) {
			
			// Getting the users character name
			System.out.println("Gib Deinen Spielernamen ein: ");
			Scanner input = new Scanner(System.in);
			String userName = input.next();
			
			// Instantiating the users' character "zombie"
			Zombie zombie = new Zombie(userName);
			
			Human enemy = new Human();
			
			// showing provisionally Main Menu
			while(Gamestart.gamestate == "mainmenu") {
				System.out.println();
				System.out.println("##############################");
				System.out.println("     H A U P T M E N Ü        ");
				System.out.println("------------------------------");
				System.out.println("Wähle aus folgenden Optionen: ");
				System.out.println("[1] MENSCHEN AUFSPÜREN        ");
				System.out.println("[2] STATUS        ");
				System.out.println();
				System.out.println("[3] BEENDEN       ");
				System.out.println("##############################");
				System.out.println();
				int choice = input.nextInt();
				
				// switch case for main menu choices
				switch (choice) {
		        	case 1: Gamestart.gamestate = "fight";
		        			// probability of finding human = 70%
		        			if( new Random().nextDouble() <= 0.7 ){
		        				Fight fight = new Fight(zombie, enemy,"zombie");
		        			} else {
		        				System.out.println("Niemand zu sehen.");
		        				System.out.println("Hunger und Zerfall steigen...");
		        				zombie.setBrainHunger(zombie.getBrainHunger() + 1.0);
		        				zombie.setDecay(zombie.getDecay() + 2.0);
		        				Gamestart.gamestate = "mainmenu";
					    		break;
		        			}
		                 	break;
		        	case 2: Gamestart.gamestate = "state";
		        			System.out.println("##################################");
				    		System.out.println(zombie.getName());
				    		System.out.println("----------------------------------");
				    		System.out.println("Zerfall:       " + zombie.getDecay() + "%");
				    		System.out.println("Stärke:        " + zombie.getStrength());
				    		System.out.println("Gehirn-Hunger: " + zombie.getBrainHunger() + "%");
				    		System.out.println("##################################");
				    		Gamestart.gamestate = "mainmenu";
				    		break;
		        	case 3: System.exit(0);
					default:
							Gamestart.gamestate = "mainmenu";
							break;
				}
			}
		}	
	}

package zombieRPG;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Gamestart {

public static void main(String[] args) {
		
		Zombie zombie = new Zombie("NameDesPlayers");

		String[] nameArray = {
			"Peter Pan",
			"HP Baxxter",
			"Guenther Jauch",
			"Heidi"
		};
		
		// setting the enemies attributes
		String name = nameArray[new Random().nextInt(nameArray.length)];
	
		int leben = ThreadLocalRandom.current().nextInt(1, 99 + 1);
		int stärke = ThreadLocalRandom.current().nextInt(1, 99 + 1);
		int hirnstärke = ThreadLocalRandom.current().nextInt(1, 99 + 1); 
				
		Human human = new Human(name, leben, stärke, hirnstärke);
		
		System.out.println("##################################       |     ##################################");
		System.out.println(human.getName() + "                           |     " + zombie.getName());
		System.out.println("----------------------------------       |     ----------------------------------");
		System.out.println("Leben:      " + human.getLives() +                  "                            |     Zerfall:    " + zombie.getDecay() + "%");
		System.out.println("Stärke:     " + human.getStrength() + "              		 |     Stärke:     " + zombie.getStrength());
		System.out.println("Hirnstärke: " + human.getBrainStrength() + "         		         |     Hirneffekt: " + zombie.getBrainPower() + "%");
		System.out.println("##################################       |     ##################################");

		System.out.println();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wähle aus folgenden Optionen: ");
		System.out.println("[1] KAMPF ");
		System.out.println("[2] FLUCHTVERSUCH ");
		int choice = scanner.nextInt();
		
		switch (choice) {
        	case 1: Fight fight = new Fight(zombie, human);
                 	break;
        	case 2: Escape escpae = new Escape(zombie, human);
        			break;
			default:
					System.exit(0);
		}	
	}	
}

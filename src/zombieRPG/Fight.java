package zombieRPG;

import java.util.Scanner;

public class Fight {

	public Fight(Zombie zombie, Human human) {
		
		
		
		// Show current state
		System.out.println("##################################       |     ##################################");
		System.out.println(human.getType() + "                           |     " + zombie.getName());
		System.out.println("----------------------------------       |     ----------------------------------");
		System.out.println("Leben:      " + human.getLives() +                  "                            |     Zerfall:    " + zombie.getDecay() + "%");
		System.out.println("Stärke:     " + human.getStrength() + "              		 |     Stärke:     " + zombie.getStrength());
		System.out.println("Hirnstärke: " + human.getBrainStrength() + "         		         |     Gehirn-Hunger: " + zombie.getBrainHunger() + "%");
		System.out.println("##################################       |     ##################################");
		System.out.println();
		
		// showing provisionally Main Menu
		System.out.println("Wähle aus folgenden Optionen: ");
		System.out.println("[1] KAMPF         ");
		System.out.println("[2] FLUCHTVERSUCH ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		// switch case for main menu choices
		switch (choice) {
        	case 1: Fight fight = new Fight(zombie, human);
                 	break;
        	case 2: Escape escpae = new Escape(zombie, human);
        			break;
			default:
					System.exit(0);
		}	
		
		float zombieStrength = (float) zombie.getStrength();
		float zombieDecay = zombie.getDecay();
		
		System.out.println(zombieStrength);
		System.out.println(zombieDecay);
		float currentStrength = zombieStrength - (-1* zombieDecay);
		
		System.out.println(currentStrength);
		
		Gamestart.gamestate = "mainmenu";
		/*
		System.out.println("###########################");
		System.out.println("        K A M P F       ");
		System.out.println("---------------------------");
		System.out.println("Zerfall = 100%");
		System.out.println("Du bist richtig tot.");
		System.out.println("###########################");
		System.exit(0);*/
	}

}

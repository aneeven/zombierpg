package zombieRPG;

import java.util.concurrent.ThreadLocalRandom;

public class Escape {

public Escape(Zombie zombie, Human human) {
		
		int dice = ThreadLocalRandom.current().nextInt(1, 5 + 1); 
	
		System.out.println("###########################");
		System.out.println("        F L U C H T       ");
		System.out.println("---------------------------");
		if(dice <= 3) {
			System.out.println("Flucht nicht geglückt.");
			System.out.println("Zerfall = 100%");
			System.out.println("Du bist richtig tot.");
		} else {
			System.out.println("Flucht geglückt");
		}
		System.out.println("###########################");
		System.exit(0);
	}
	
}

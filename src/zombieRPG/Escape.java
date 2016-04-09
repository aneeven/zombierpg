package zombieRPG;

import java.util.concurrent.ThreadLocalRandom;

/**
 * class Escape
 * 
 * This class contains the escape mechanism of the game.
 * It holds the methods for users' choice to escape a fight.
 * 
 * @author f.petruschke
 *
 */
public class Escape {

	/**
	 * escape
	 * 
	 * The methode will choose whether the user can escape or not by random
	 * If the users try failes the enemy/human will begin next fight round
	 * 
	 * @param zombie	Zombie object
	 * @param human		Human object
	 */
	public Escape(Zombie zombie, Human human) {
		
		// throw new dice for randomly choosing the according event
		int dice = ThreadLocalRandom.current().nextInt(1, 5 + 1);
		if(dice <= 3) {
			System.out.println();
			System.out.println("###########################");
			System.out.println("         K A M P F         ");
			System.out.println("---------------------------");
			System.out.println("Flucht nicht geglückt.");
			System.out.println(human.getName() + " greift Dich an...");
			System.out.println("###########################");
			System.out.println();
			Fight fight = new Fight(zombie, human,"human");
		} else {
			System.out.println();
			System.out.println("###########################");
			System.out.println("        F L U C H T       ");
			System.out.println("---------------------------");
			System.out.println("Flucht geglückt");
			System.out.println("###########################");
			System.out.println();
			
			/**
			 * @toDo find a safe way to completely unset the human!
			 */
			human = null;
			Fight.gamecircle = false;
			Gamestart.gamestate = "mainmenu";
		}
	}
}

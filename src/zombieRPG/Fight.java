package zombieRPG;

public class Fight {

	public Fight(Zombie zombie, Human human) {
		
		float zombieStärke = (float) zombie.getStrength();
		float zombieZerfall = zombie.getDecay();
		
		System.out.println(zombieStärke);
		System.out.println(zombieZerfall);
		float tatsächlicheStärke = zombieStärke - (-1* zombieZerfall);
		
		System.out.println(tatsächlicheStärke);
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

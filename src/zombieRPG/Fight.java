package zombieRPG;

public class Fight {

	public Fight(Zombie zombie, Human human) {
		
		float zombieStrength = (float) zombie.getStrength();
		float zombieDecay = zombie.getDecay();
		
		System.out.println(zombieStrength);
		System.out.println(zombieDecay);
		float currentStrength = zombieStrength - (-1* zombieDecay);
		
		System.out.println(currentStrength);
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

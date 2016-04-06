package zombieRPG;

public class Human {

	public String name;
	public int lives;
	public int strength;
	public int brainStrength;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getBrainStrength() {
		return brainStrength;
	}

	public void setBrainStrength(int brainStrength) {
		this.brainStrength = brainStrength;
	}

	// Constructor
	public Human(String name, int lives, int strength, int brainStrength) {
	    this.name = name;
	    this.lives = lives;
	    this.strength = strength;
	    this.brainStrength = brainStrength;
	}
	
	
	/*public static void main(String[] args) {
		
		Human human = new Human("Gegnername", 3, 5, 2);
		System.out.println("##################################");
		System.out.println(human.getName());
		System.out.println("----------------------------------");
		System.out.println("Leben:      " + human.getLeben());
		System.out.println("St�rke:     " + human.getSt�rke());
		System.out.println("Hirnst�rke: " + human.getHirnSt�rke());
		System.out.println("##################################");

	}*/

}

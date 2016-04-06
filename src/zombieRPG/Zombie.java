package zombieRPG;

public class Zombie {

	public String name = "";
	public float decay = 50;
	public int strength = 50;
	public float brainPower = 50;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public float getDecay() {
		return decay;
	}

	public void setDecay(float decay) {
		this.decay = decay;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public float getBrainPower() {
		return brainPower;
	}

	public void setBrainPower(float brainPower) {
		this.brainPower = brainPower;
	}
	
	// Constructor
	public Zombie(String name) {
	    this.name = name;
	}
	
	/*public static void main(String[] args) {
		
		Zombie zombie = new Zombie("Hier steht der Charaktername");
		System.out.println("##################################");
		System.out.println(zombie.getName());
		System.out.println("----------------------------------");
		System.out.println("Zerfall:    " + zombie.getZerfall() + "%");
		System.out.println("St�rke:     " + zombie.getSt�rke());
		System.out.println("Hirneffekt: " + zombie.getHirnEffekt() + "%");
		System.out.println("##################################");
	}*/

}

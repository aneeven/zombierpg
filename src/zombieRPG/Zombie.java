package zombieRPG;

/**
 * 
 * Zombie
 * 
 * Class stands for users character - the zombie
 * 
 * @author f.petruschke
 *
 */
public class Zombie {

	public String name = "";
	public double decay = 50;
	public int strength = 5;
	public double brainHunger = 50.0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getDecay() {
		return decay;
	}

	public void setDecay(double decay) {
		this.decay = decay;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public double getBrainHunger() {
		return brainHunger;
	}

	public void setBrainHunger(double brainHunger) {
		this.brainHunger = brainHunger;
	}
	
	/**
	 * constructor
	 * 
	 * Sets the users character name
	 * 
	 * @param name
	 */
	public Zombie(String name) {
	    this.name = name;
	}
}

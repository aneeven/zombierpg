package zombieRPG;

import java.util.Hashtable;
import java.util.Random;

public class Human {

	public String type;
	public int lives;
	public int strength;
	public int brainStrength;
	public Boolean hasItem;
	public int itemStrength;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	public boolean getHasItem() {
		return this.hasItem;
	}
	
	public void setHasItem(boolean hasItem) {
		this.hasItem = hasItem;
	}
	
	public int getItemStrength() {
		return this.itemStrength;
	}
	
	public void setItemStrength(int itemStrength) {
		this.itemStrength = itemStrength;
	}

	// Constructor
	public Human(String type, int lives, int strength, int brainStrength, boolean hasItem, int itemStrength) {
	    this.type = type;
	    this.lives = lives;
	    this.strength = strength;
	    this.brainStrength = brainStrength;
	    this.hasItem = hasItem;
	    this.itemStrength = itemStrength;
	}
	
	public Human() {
		
		// mapping for associative two-dimensional arrays with hashtable
		Hashtable douchbag = new Hashtable();
		// insert all elements into hashtable
		douchbag.put( "type", "douchebag");
		douchbag.put( "lives", "1");
		douchbag.put( "strength", "1");
		douchbag.put( "brainStrength", "1");
		douchbag.put( "hasItem", "0");
		douchbag.put( "itemStrength", "0");
		
		Hashtable handwerker = new Hashtable();
		// insert all elements into hashtable
		handwerker.put( "type", "handwerker");
		handwerker.put( "lives", "3");
		handwerker.put( "strength", "10");
		handwerker.put( "brainStrength", "2");
		handwerker.put( "hasItem", "1");
		handwerker.put( "itemStrength", "6");

		Hashtable[] enemies = {douchbag, handwerker};
		
		// get random enemy
		Random random = new Random();
		int randomIndex = random.nextInt(enemies.length);
		String randomEnemyType = (String) enemies[randomIndex].get("type");
		String randomEnemyLives = (String) enemies[randomIndex].get("lives");
		String randomEnemyStrength = (String) enemies[randomIndex].get("strength");
		String randomEnemyBrainStrength = (String) enemies[randomIndex].get("brainStrength");
		String randomEnemyItem = (String) enemies[randomIndex].get("hasItem");
		String randomEnemyItemStrength = (String) enemies[randomIndex].get("itemStrength");
		
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println(randomEnemyType);
		System.out.println(randomEnemyLives);
		System.out.println(randomEnemyStrength);
		System.out.println(randomEnemyBrainStrength);
		System.out.println(randomEnemyItem);
		System.out.println(randomEnemyItemStrength);
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println("#####################################");
		
		// get an element specified by it's key
		//String enemyType = (String) douchbag.get( "type" );
		//System.out.println(enemyType);
		
		/*// mapping for associative two-dimensional arrays with hashtable
		Hashtable douchbag = new Hashtable();
		// insert all elements into hashtable
		douchbag.put( "type", "douchebag");
		douchbag.put( "lives", 1);
		douchbag.put( "strength", 1);
		douchbag.put( "brainStrength", 1);
		douchbag.put( "hasItem", 0);
		douchbag.put( "itemStrength", 0);

		// get an element specified by it's key
		String enemyType = (String) douchbag.get( "type" );
		System.out.println(enemyType);*/
		
		/*
		 * type: "Douchbag"
		 * lives: 1
		 * strength: 1
		 * brainStrength: 1
		 * hasItem: 0
		 * itemStrength: 0
		 */
		
//"Douchebag" "Handwerker" "Akademiker" "Soldat"
		
		this.type = type;
	    this.lives = lives;
	    this.strength = strength;
	    this.brainStrength = brainStrength;
	    this.hasItem = hasItem;
	    this.itemStrength = itemStrength;
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

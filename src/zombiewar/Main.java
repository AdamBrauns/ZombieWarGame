package zombiewar;

import zombiewar.impl.CharacterFactory;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * @author thaoc
 */
public class Main {

	private static final ICharacterFactory factory = CharacterFactory.instance;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		IZombie[] zombies = randomZombies();
		ISurvivor[] survivors = randomSurvivors();

	  System.out.print("We have " + survivors.length + " survivors trying to make it to safety. (");
	  int numCommon = 0, numTank = 0, numPredator = 0; 
	  
	  for(IZombie element: zombies){
		  if(element instanceof Common){
			  numCommon++;
		  }else if(element instanceof Tank){
			  numTank++;
		  }else if(element instanceof Predator){
			  numPredator++;
		  }
	  }
	  if(numCommon>0){
		  System.out.print(numCommon+" Common ");
	  }
	  if(numTank>0){
		  System.out.print(numTank+" Tank ");
	  }
	  if(numPredator>0){
		  System.out.print(numPredator+" Predator ");
	  }
	  
	  
	  System.out.println(")\nBut there are " + zombies.length + " zombies waiting for them.\n");
		//      When all the survivors have done attacking, it's the zombies'
		//      turn to attack.  For each zombie that is still alive, attack
		//      each suvivor that is still alive.  Repeat this cycle until
		//      all the zombies are all dead or all the survivors are all dead.

		while (true) {
			survivorsAttack(survivors, zombies);
			zombiesAttack(survivors, zombies);

			if (allDead(zombies) || allDead(survivors)) { break; }
		}

		if (allDead(survivors)) {
			System.out.println("None of the survivors made it.");
		} else {
			int count = 0;
			for (ISurvivor survivor : survivors) {
				if (survivor.isAlive()) { count++; }
			}
			System.out.println("It seems " + count + " have made it to safety.");
		}

	}

	public static IZombie[] randomZombies() {
		int numZombies = (int) (Math.random() * 10);
		IZombie[] zombies = new IZombie[numZombies];
		for (int i = 0; i < zombies.length; i++) {
			int zombieType = (int) (Math.random() * 5);
			switch (zombieType) {
				case 0:
					zombies[i] = (IZombie) factory.make("common");
					break;
				case 1:
					zombies[i] = (IZombie) factory.make("tank");
					break;
				case 2:
					zombies[i] = (IZombie) factory.make("predator");
					break;
				case 3:
					zombies[i] = (IZombie) factory.make("radioactivezombie");
					break;
				case 4:
					zombies[i] = (IZombie) factory.make("spitter");
					break;
			}
		}
		return zombies;
	}

	public static ISurvivor[] randomSurvivors() {
		int numZombies = (int) (Math.random() * 20);
		ISurvivor[] survivors = new ISurvivor[numZombies];
		for (int i = 0; i < survivors.length; i++) {
			int type = (int) (Math.random() * 6);
			switch (type) {
				case 0:
					survivors[i] = (ISurvivor) factory.make("soldier");
					break;
				case 1:
					survivors[i] = (ISurvivor) factory.make("teacher");
					break;
				case 2:
					survivors[i] = (ISurvivor) factory.make("student");
					break;
				case 3:
					survivors[i] = (ISurvivor) factory.make("child");
					break;
				case 4:
					survivors[i] = (ISurvivor) factory.make("dog");
					break;
				case 5:
					survivors[i] = (ISurvivor) factory.make("military");
			}
		}
		return survivors;
	}

	public static void survivorsAttack(ISurvivor[] survivors, IZombie[] zombies) {
		for (ISurvivor survivor : survivors) {
			for (IZombie zomby : zombies) {
				// each survivor attacks each zombie if they're both alive
				if (survivor.isAlive() && zomby.isAlive()) {
					survivor.attack(zomby);
					//if survivor kills a zombie, print out their accomplishment
					if (!zomby.isAlive()) {
						System.out.println(survivor + " " + survivor.getIndex() + " killed " + zomby + " " + zomby.getIndex());
					}
				}
			}
		}
	}

	public static void zombiesAttack(ISurvivor[] survivors, IZombie[] zombies) {
		for (IZombie zomby : zombies) {
			for (ISurvivor survivor : survivors) {
				// each zombie attacks each survivor if they're both alive
				if (survivor.isAlive() && zomby.isAlive()) {
					zomby.attack(survivor);
				}
				//if zombie kills a survivor, print out their accomplishment
				if (!survivor.isAlive()) {
					System.out.println(zomby + " " + zomby + " killed " + survivor + " " + survivor);
				}
			}
		}
	}

	public static boolean allDead(ICharacter[] characters) {
		boolean allDead = true;
		for (ICharacter character : characters) {
			allDead &= !character.isAlive();
		}
		return allDead;
	}


}

package zombiewar;

import zombiewar.impl.CharacterFactory;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 *
 * @author thaoc
 */
public class Main {
  
  private static final ICharacterFactory factory = CharacterFactory.instance;
  
  public static IZombie[] randomZombies() {
    int numZombies = (int) (Math.random() * 10);
    IZombie[] zombies = new IZombie[numZombies];
    for (int i = 0; i < zombies.length; i++) {
      int zombieType = (int) (Math.random() * 2);
      switch(zombieType){
        case 0: zombies[i] = (IZombie) factory.make("common"); break;
        case 1: zombies[i] = (IZombie) factory.make("tank"); break;
        case 2: zombies[i] = (IZombie) factory.make("predator"); break;
      }
    }
    return zombies;
  }

  public static ISurvivor[] randomSurvivors() {
    int numZombies = (int) (Math.random() * 20);
    ISurvivor[] survivors = new ISurvivor[numZombies];
    for (int i = 0; i < survivors.length; i++) {
      int type = (int) (Math.random() * 3);
      switch(type){
        case 0: survivors[i] = (ISurvivor) factory.make("soldier"); break;
        case 1: survivors[i] = (ISurvivor) factory.make("teacher"); break;
        case 2: survivors[i] = (ISurvivor) factory.make("student"); break;
        case 3: survivors[i] = (ISurvivor) factory.make("child"); break;
      }
    }
    return survivors;
  }

  public static boolean allDead(ICharacter[] characters){
    boolean allDead = true;
    for(int i=0; i<characters.length; i++){
      allDead &= !characters[i].isAlive();
    }
    return allDead;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

	  IZombie[] zombies = randomZombies();
	  ISurvivor[] survivors = randomSurvivors();

	  System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
	  System.out.println("But there are " + zombies.length + " zombies waiting for them.");

	  //TODO: the survivors attack first.  One character attack each zombie.
	  //      When all the survivors have done attacking, it's the zombies'
	  //      turn to attack.  For each zombie that is still alive, attack
	  //      each suvivor that is still alive.  Repeat this cycle until
	  //      all the zombies are all dead or all the survivors are all dead.

	  while (true) {
		  survivorsAttack(survivors, zombies);
		  zombiesAttack(survivors, zombies);

		  if ( allDead(zombies) || allDead(survivors) ) break;
	  }

	  if (allDead(survivors)) {
		  System.out.println("None of the survivors made it.");
	  } else {
		  int count = 0;
		  for (int i = 0; i < survivors.length; i++) {
			  if (survivors[i].isAlive()) count++;
		  }
		  System.out.println("It seems " + count + " have made it to safety.");
	  }

  }

	public static void survivorsAttack( ISurvivor[] survivors, IZombie[] zombies ){
		//System.out.println( "Survivors Turn:\n" );
		for (int i = 0; i < survivors.length; i++) {
			for (int j = 0; j < zombies.length; j++) {
				// each survivor attacks each zombie if they're both alive
				if (survivors[i].isAlive() && zombies[j].isAlive()) {
					survivors[i].attack(zombies[j]);

				}
			}
		}
	}

	public static void zombiesAttack( ISurvivor[] survivors, IZombie[] zombies ){
		//System.out.println( "\nZombies' Turn:\n" );
		for (int i = 0; i < zombies.length; i++) {
			for (int j = 0; j < survivors.length; j++) {
				// each zombie attacks each survivor if they're both alive
				if (survivors[j].isAlive() && zombies[i].isAlive()) {
					zombies[i].attack(survivors[j]);
				}
			}
		}
	}

	// Release 2.0 functionality:
	/* //if survivor kills a zombie, print out their accomplishment
					if (!zombies[j].isAlive()) {
						System.out.println(survivors[i] + " " + i + " killed " + zombies[j] + " " + j);
					}

		//if zombie kills a survivor, print out their accomplishment
		if ( !survivors[j].isAlive() ) {
			System.out.println(zombies[i] + " " + i + " killed " + survivors[j] + " " + j);
		}
	*/


}

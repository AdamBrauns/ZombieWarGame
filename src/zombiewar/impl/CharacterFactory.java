
package zombiewar.impl;

import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;

/**
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory {

	public static final ICharacterFactory instance = new CharacterFactory();

	private CharacterFactory() {

	}

	/**
	 * Make the character.  To support more characters,
	 * simply implement a type and then add a case statement
	 * to this method.
	 *
	 * @param type The type of character to make.
	 * @return the character object, otherwise, a null object.
	 */

	@Override
	public ICharacter make(String type) {
		switch (type) {

			case "common":
				return new Common();
			case "tank":
				return new Tank();
			case "predator":
				return new Predator();
			case "soldier":
				return new Soldier();
			case "teacher":
				return new Teacher();
			case "student":
				return new Student();
			case "child":
				return new Child();
			case "dog":
				return new Dog();
			case "radioactivezombie":
				return new RadioactiveZombie();
			case "spitter":
				return new Spitter();
			case "military":
				return new Military();
			case "undeaddog":
				return new UndeadDog();
			case "undeadbear":
				return new UndeadBear();
		}
		return null;
	}

}

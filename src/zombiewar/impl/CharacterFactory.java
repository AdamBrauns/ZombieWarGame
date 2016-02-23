
package zombiewar.impl;

import com.sun.javaws.exceptions.InvalidArgumentException;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
/**
 *
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory{
  
  public static final ICharacterFactory instance = new CharacterFactory();
  
  private CharacterFactory(){
   
  }

  /**
   * Make the character.  To support more characters,
   * simply implement a type and then add a case statement
   * to this method.
   * 
   * @param type The type of character to make.
   * @return 
   */
  
  @Override
  public ICharacter make(String type) {
    switch(type){
      case "common": return new Common();
      case "tank": return new Tank();
      case "predator": return new Predator();
      case "soldier": return new Soldier();
      case "teacher": return new Teacher();
      case "student": return new Student();
      case "child": return new Child();
    }//end switch

    throw new IllegalArgumentException(type + " is not a type of zombie or survivor");
  }
  
}

package zombiewar.intf;

public interface ICharacterFactory{

  //Make a character. If type is soldier, return a Solider object.
  ICharacter make(String type);

}

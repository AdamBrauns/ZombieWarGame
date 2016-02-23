package zombiewar.intf;
package zombiewar.impl;

public interface ICharacterFactory{
 
  //Make a character. If type is soldier, return a Solider object.
  public ICharacter make(String type){
   
    switch(type){
     
      case "common": return new Common();
      break;
      
      case "tank": return new Tank();
      break;
      
      case "predator": return new Predator();
      break;
      
      case "soldier": return new Soldier();
      break;
      
      case "teacher": return new Teacher();
      break;
      
      case "student": return new Student();
      break;
      
      case "child": return new Child();
      break;
      
    }//end switch
   
  }//end make 

}

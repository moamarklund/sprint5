/**
 * @author Malin Englund 
 * @version 1.0 
 * @since 2015-11-16
 */

/**
 * Represents a creature 
 * @param course The course of the creature
 **/   
public class Creature{ 
  
    protected Course course; 
    
    /**
     * Creates a creature
     * @param course The course of the creature
     **/
        public Creature(Course course){ 
	this.course = course; 
    } 

    /**
     * Makes the creature talk to the avatar in the game
     **/
    void talk(Avatar avatar){ 
	System.out.println("not implemented yet"); 
    }
 
}
	
    

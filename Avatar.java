import java.util.*;
/**
 * Represents the avatar in the game
 * @param unfinishedCourses The avatar´s unfinished courses
 * @param finishedCourses The avatar´s finished courses
 * @param HP The total amount of HP the avatar has collected
 * @param backpack The backpack with the avatars items 
 **/
public class Avatar { 

    private final List<Course> unfinishedCourses; 
    private final List<Course> finishedCourses; 
    private int HP; 
    private Backpack backpack; 

    /**
     * Creates an avatar 
     **/
    public Avatar(){ 
	unfinishedCourses = new ArrayList<Course>(); 
	finishedCourses = new ArrayList<Course>();
    } 

    /**
     * Checks the unfinished courses of the avatar
     * @return the unfinished courses
     **/
    public List<Course> getUnfinishedCourses(){ 
	return unfinishedCourses; 
    } 

    
    /**
     * Checks the finished courses of the avatar
     * @return the finished courses 
     **/
    public List<Course> getFinishedCourses(){ 
	return finishedCourses; 
    } 

    
    /**
     * Checks how many HP the avatar has
     * @return the amount of HP
     **/
    public int getHP(){ 
	return this.HP; 
    }

    
    /**
     * Checks the backpack of the avatar
     * @return the avatar´s backpack
     **/
    public Backpack getBackpack(){ 
	return this.backpack; 
    }
}

import java.util.*;

public class Avatar { 

    //Attribut 
    private final List<Course> unfinishedCourses; 
    private final List<Course> finishedCourses; 
    private int HP; 
    private Backpack backpack; 

    public Avatar(){ 
	unfinishedCourses = new ArrayList<Course>(); //ööh man måste ju fylla listorna på nåt sätt
	finishedCourses = new ArrayList<Course>();
    } 

    //Metoder
    public List<Course> getUnfinishedCourses(){ 
	return unfinishedCourses; 
    } 

    public List<Course> getFinishedCourses(){ 
	return finishedCourses; 
    } 
    
    public int getHP(){ 
	return this.HP; 
    }

    public Backpack getBackpack(){ 
	return this.backpack; 
    }
}

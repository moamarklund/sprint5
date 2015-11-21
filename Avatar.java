import java.util.*;

public class Avatar { 

    //Attribut 
    private final ArrayList<Course> unfinishedCourses; 
    private final ArrayList<Course> finishedCourses; 
    private int HP; 
    private Backpack backpack; 

    public Avatar(){ 
	unfinishedCourses = new ArrayList<Course>(); 
	finishedCourses = new ArrayList<Course>();
    }
}

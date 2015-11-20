import java.util.*; 

public class Books extends Objects {

    private Course course;

    public Books(String name, int setWeight){
	    super(name, setWeight); 
	    this.course = new Course();
	}

    //Metoder 
    public Course getCourse(){ 
	return this.course; 
    }
}

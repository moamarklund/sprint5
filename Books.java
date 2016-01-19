import java.util.*; 

public class Books extends Item {

    private Course course;
    private String author; 
    private int year; 

    public Books(String name, String author, int year, int weight, Course course){
	    super(name, weight); 
	    this.course = course;
	    this.year = year; 
	    this.author = author;
    }

    //Metoder 
    public Course getCourse(){ 
	return this.course; 
    } 

    public String getCourseName(){
	return this.course.getName(); 
    } 

    public String getName(){ 
	return super.getName(); 
    } 

    public String toString(){ 
	return "Boktitel : " + name;
    }
}

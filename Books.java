import java.util.*; 

/**
 * Represents a book
 * @param course The course the book belongs to
 * @param author The author of the book
 * @param year The publishing year of the book 
 **/
public class Books extends Item {

    private Course course;
    private String author; 
    private int year; 

    
    /**
     * Creates a book
     * @param name The name of the book
     * @param author The author of the book
     * @param year The publishing year of the book
     * @param weight The weight of the book
     * @param course The course the book belongs to 
     **/
    public Books(String name, String author, int year, int weight, Course course){
	    super(name, weight); 
	    this.course = course;
	    this.year = year; 
	    this.author = author;
    }

    
    /**
     * Checks the book´s course
     * @return The course the book belongs to
     **/ 
    public Course getCourse(){ 
	return this.course; 
    } 

    
    /**
     * Checks the name of the course the book belongs to 
     * @return The name of the course
     **/
    public String getCourseName(){
	return this.course.getName(); 
    } 

    /**
     * Checks the name of the book
     * @return The name of the book
     **/
    public String getName(){ 
	return super.getName(); 
    } 

    /**
     * Prints the book´s name out as a string
     * @return The name of the book as a string 
     **/
    public String toString(){ 
	return "Boktitel : " + name;
    }
}

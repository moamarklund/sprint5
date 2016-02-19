/**
 * @author Malin Englund and Moa Marklund
 * @since 2015/2016
 */

import java.util.*; 

public class Student extends Creature{ 

    //Attribut 
    private String name; 
    private Course doneCourse; 
    private Books book; 

    //Konstruktor
    /** 
     *The constructor creates a student
     *@param name is the student's name 
     *@param book is the book for the student's done course 
     *@param course is the that the student study now 
     */
    public Student(String name, Books book, Course course){ 
	super(course); 
	this.name = name; 
	this.book = book; 
	this.doneCourse = book.getCourse();
    } 

    //Metoder  
    /** 
     *Gets the name for the student 
     *@return the student's name
     */
    public String getName(){ 
	return this.name; 
    } 

    /** 
     *Gets the book for the student 
     *@return the student's book
     */
    public Books getBook(){ 
	return this.book;
    } 

    public Course getCourse(){ 
	return this.course; 
    }

    /**
     *The student says something.
     *@param avatar is the thing that the student talks to 
     */
    public void talk(Avatar avatar){ 
	System.out.println("Hi! My current course is" + this.course + "and my done course is" + this.doneCourse +". If you have the book for my current course, we can trade!");
    }  

    /** 
     *Switchs books or gives the avatar the right answer
     *@param avatar is the avatar that the student interacts with
     *@param name is the student's name 
     */
    public void trade(Avatar avatar, String name){ 
	if(name.equals(this.name)) { 
	    //om boken finns i avatarens backpack 
	    if(checkBackpack(avatar)) { //kolla om avataren är registerad på kursen?
		System.out.print("Would you like the book:" + this.book + "or the right answer to the teachers question? <b> or <r>"); 
		String answer = readInput("b","r");
		//studenten ger avataren sin gamla kursbok och uppdatera studentens bok 
		if (answer.equals("b")) {
		    Backpack b = avatar.getBackpack(); 
		    b.pack(this.book); 
		    this.book = removeBookForCourse(avatar);
		} 
		//eller uppdatera course rightanswer till true och uppdatera studentens bok
		if (answer.equals("r")) { 
		    this.course.setRightAnswer(true);
		    this.book = removeBookForCourse(avatar);
		}
	    }
	} 
	else System.out.print("Wrong name!!!");
    } 

    /** 
     *The function reads input from the user and checks if it is valid.
      *@param a is an allowed input from the user     *@param a is an allowed input from the user 
     *@param b is an allowed input from the user 
     *@return the input from the user 
     */
    public String readInput(String a, String b){ 
	String answer = "";
	while(true){ 
	    Scanner sc = new Scanner(System.in);
	    answer = sc.next(); 
	    if((answer.equals(a))||(answer.equals(b))) break; 
	    else System.out.print("Valid inputs are" + a + b);    
	} 
	return answer; 
    }

    /**
     *The function removes the book for the student's active course.
     *@param avatar's backpack is where the function is going to remove the book
     *@return The removed book if it was found and removed else an "empty" book
     */ 
    public Books removeBookForCourse(Avatar avatar){ 
	Backpack b = avatar.getBackpack();
	return b.removeBookForCourse(this.course);
    }

    /** 
     *The function checks if the book with the belonging course c is in the backpack. 
     *@param c is the course that belongs to the book that is going to be checked 
     *@return true if the book was found else false
     */
    public boolean checkBackpack(Avatar avatar){ 
	Backpack b = avatar.getBackpack();
	return b.checkCourse(this.course);
    } 

    /** 
     *toString method for the student class. 
     *@return a string containing the student's name
     */
    public String toString(){ 
	return name; 
    }
}
    


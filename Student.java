import java.util.*; 

public class Student extends Creature{ 

    //Attribut 
    private String name; 
    private Course doneCourse; 
    private Books book; 
    private boolean rightAnswer; 

    //Konstruktor 
    public Student(String name, Books book, Course course){ 
	super(course); 
	this.name = name; 
	this.doneCourse = book.getCourse();
	this.book = book; 
	rightAnswer = false;
    } 
} 
/*
    //Metoder 
    public void talk(){ 
	System.out.print("Hi! What would you like to know about me?\n1.My done course\n2.My current course"); 
	

Studenter finns litet här och var i de olika rummen. Varje student går en kurs och har klarat en annan. Om man kan ge studenten kursboken för den kurs som studenten går kan man få något i utbyte: antingen kursboken för den andra kursen, eller rätt svar på lärarens fråga för den kursen.

För att prata med en student används "talk" och studentens namn. För att byta böcker med en student används "trade" och namnet.
    
*/

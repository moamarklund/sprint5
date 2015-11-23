import java.util.*;

public class Course{ 

    //Attribut 
    private String name;
    private int HP;
    private final ArrayList<String> questionAndAnswers1; 
    private final ArrayList<String> questionAndAnswers2;
    private final ArrayList<String> questionAndAnswers3;
    
    //Konstruktorer
    public Course(String name, ArrayList<String> questionAndAnswers1, ArrayList<String> questionAndAnswers2, ArrayList<String> questionAndAnswers3, int HP){ 
	this.HP = HP; 
	this.name = name; 
	this.questionAndAnswers1 = questionAndAnswers1; //nu referar listorna till samma punkt, är det bra eller? förvirringen är total
	this.questionAndAnswers2 = questionAndAnswers2; 
	this.questionAndAnswers3 = questionAndAnswers3; 

    }

    public Course(String name, ArrayList<String> questionAndAnswers1, ArrayList<String> questionAndAnswers2, ArrayList<String> questionAndAnswers3){ 
	this(name,questionAndAnswers1,questionAndAnswers2,questionAndAnswers3, 10);
    } 
    
    //Metoder 
    public String getName(){ 
	return this.name; 
    }
}
    
    
	

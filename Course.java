import java.util.*;

public class Course{ 

    //Attribut 
    private String name;
    private int HP;
    //index 0 i s the question,index 1 is the rightanswer, 2 & 3 are false answers
    private final ArrayList<String> questionAndAnswers1; 
    private final ArrayList<String> questionAndAnswers2;
    private final ArrayList<String> questionAndAnswers3;
    private boolean rightAnswer;
    
    //Konstruktorer
    public Course(String name, ArrayList<String> questionAndAnswers1, ArrayList<String> questionAndAnswers2, ArrayList<String> questionAndAnswers3, int HP){ 
	this.HP = HP; 
	this.name = name; 
	this.questionAndAnswers1 = questionAndAnswers1; 
	this.questionAndAnswers2 = questionAndAnswers2; 
	this.questionAndAnswers3 = questionAndAnswers3;
	this.rightAnswer = false;
    }

    public Course(String name, ArrayList<String> questionAndAnswers1, ArrayList<String> questionAndAnswers2, ArrayList<String> questionAndAnswers3){ 
	this(name,
	     questionAndAnswers1,
	     questionAndAnswers2,
	     questionAndAnswers3,
	     10);
    } 
    
    //Metoder  
    public void setRightAnswer(boolean setBool){ 
	this.rightAnswer = setBool; 
    } 

    public boolean getRightAnswer(){ 
	return this.rightAnswer; 
    }

    public String getName(){ 
	return this.name; 
    } 
    
    public int getHP(){ 
	return this.HP; 
    }

    public ArrayList<String> getQuestionAndAnswers(int choice){ 
	if(choice == 1) return this.questionAndAnswers1; 
	if(choice == 2) return this.questionAndAnswers2; 
	else return this.questionAndAnswers3; 
    }
}
    
    
	

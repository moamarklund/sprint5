import java.util.*;


/**
 * Represents a course
 * @param name The name of the course
 * @param HP The number of HP the course is 
 * @param questionAndAnswers1 The first question of the course with answer
 * @param questionAndAnswers2 The second question of the course with answer
 * @param questionAndAnswers3 The third question of the course with answer
 * @param rightAnswer The right answer to the question
 **/
public class Course{ 
    
    private String name;
    private int HP;
    //index 0 i s the question,index 1 is the rightanswer, 2 & 3 are false answers
    private final ArrayList<String> questionAndAnswers1; 
    private final ArrayList<String> questionAndAnswers2;
    private final ArrayList<String> questionAndAnswers3;
    private boolean rightAnswer;
    
    /**
     * Creates a course with a set amount of HP
     * @param name The name of the course
     * @param questionAndAnswers1 The first question of the course with answer
     * @param questionAndAnswers2 The second question of the course with answer
     * @param questionAndAnswers3 The third question of the course with answer
     * @param HP The number of HP the course is 
     **/
    public Course(String name, ArrayList<String> questionAndAnswers1, ArrayList<String> questionAndAnswers2, ArrayList<String> questionAndAnswers3, int HP){ 
	this.HP = HP; 
	this.name = name; 
	this.questionAndAnswers1 = questionAndAnswers1; 
	this.questionAndAnswers2 = questionAndAnswers2; 
	this.questionAndAnswers3 = questionAndAnswers3;
	this.rightAnswer = false;
    }

    /**
     * Creates a course without a set amount of HP
     * @param name The name of the course
     * @param questionAndAnswers1 The first question of the course with answer
     * @param questionAndAnswers2 The second question of the course with answer
     * @param questionAndAnswers3 The third question of the course with answer
     **/
    public Course(String name, ArrayList<String> questionAndAnswers1, ArrayList<String> questionAndAnswers2, ArrayList<String> questionAndAnswers3){ 
	this(name,
	     questionAndAnswers1,
	     questionAndAnswers2,
	     questionAndAnswers3,
	     10);
    } 
    
    /**
     * Sets the right answer to a question
     * @param setBool The boolean deciding which answer to be right 
     **/
    public void setRightAnswer(boolean setBool){ 
	this.rightAnswer = setBool; 
    } 

    /**
     * Checks the right answer
     * @return A boolean representing the right answer
     **/
    public boolean getRightAnswer(){ 
	return this.rightAnswer; 
    }

    /**
     * Checks the name of the course
     * @return The name of the course
     **/
    public String getName(){ 
	return this.name; 
    } 
    /**
     * Checks the HP of the course
     * @return The amount of HP the course has
     **/
    public int getHP(){ 
	return this.HP; 
    }

    /**
     * Chooses a question to be answered 
     * @param choice The chosen number of the question
     * @return The chosen question
     **/
    public ArrayList<String> getQuestionAndAnswers(int choice){ 
	if(choice == 1) return this.questionAndAnswers1; 
	if(choice == 2) return this.questionAndAnswers2; 
	else return this.questionAndAnswers3; 
    }
}
    
    
	

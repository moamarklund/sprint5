import java.util.*; 

public class Teacher extends Creature{

    //Konstruktor 
    public Teacher(Course course){ 
	super(course); 
    } 

    //Metoder 
    public void enroll(Avatar avatar, String course_name){ 
	if(course_name == this.course.getName()){ 
	    List<Course> list = avatar.getUnfinishedCourses();
	    list.add(this.course);
	} 
	else System.out.print("I don't teach that course, enroll failed");
    } 

    public void talk(Avatar avatar){ 
	List<Course> list1 = avatar.getUnfinishedCourses();
	List<Course> list2 = avatar.getFinishedCourses(); 

	//if ej avklarad/oavklarad kurs 
	if(!(searchListForName(list1) && searchListForName(list2))){ 
	    System.out.print("Do you wish to enroll the course? If so, answer enroll " + this.course + "else no"); 
	    String nameOfCourse = this.course.getName();
	    String answer = readInput("enroll " + nameOfCourse, "no");
	    if(answer == "enroll" + nameOfCourse){
		enroll(avatar,nameOfCourse);
	    } 
	    //else felmeddelande?
	}

	//if oavklarad kurs- 75% chans för fråga och en student inte inte gett rätt svar, flervalsfråga med tre alternativ, om bok två alternativ 
	if(searchListForName(list1)){
	    if(percent(75) && !(this.course.getRightAnswer())){ 
		boolean rightAnswer = askQuestions(avatar);
	    
		//om rätt svar lägg till coursen i finishedCourse listan, ta bort ur unfinishedCourse och lägg till HP
		if(rightAnswer){ 
		    System.out.print("Your answer is right!!!");
		    boolean success = removeAndAdd(list1, list2);
		    int HP = this.course.getHP(); 
		    int avatarHP = avatar.getHP(); 
		    avatarHP += HP;
		    assert(!success);
		} 
	    } 
	    if(this.course.getRightAnswer()){ 
		System.out.print("I see a student gave you the right answer... You know that's cheating! But it's ok for this time");
		boolean success = removeAndAdd(list1, list2);
		int HP = this.course.getHP(); 
		int avatarHP = avatar.getHP(); 
		avatarHP += HP;
		assert(!success); 
	    } 
		
	} 

	//if avklarad kurs- 50% chans för fråga och student inte inte gett rätt svar,flervalsfråga med tre alternativ,om bok två alternativ 
	else if(searchListForName(list2)){
	    if(percent(50) && !(this.course.getRightAnswer())){
		boolean rightAnswer = askQuestions(avatar);
		//om fel svar lägg till kursen i unfinishedcourses, ta bort ur finishedCourses och ta bort HP
		if(!rightAnswer){ 
		    boolean success = removeAndAdd(list2, list1);
		    int HP = this.course.getHP(); 
		    int avatarHP = avatar.getHP(); 
		    avatarHP -= HP;
		    assert(!success);
		} 
	    } 
	    if(this.course.getRightAnswer()) { 
		System.out.print("I see a student gave you the right answer... You know that's cheating! But it's ok for this time");
		this.course.setRightAnswer(false);
	    }
	} 	    
    } 

    public boolean removeAndAdd(List<Course> removeElementFromList, List<Course> addElementToList){ 
	boolean removeSuccess = removeElementFromList.remove(this.course); 
	boolean addSuccess = addElementToList.add(this.course); 
	if (removeSuccess && addSuccess) return true; 
	else return false; 
    }

    public boolean askQuestions(Avatar avatar){ 
	int questionToBeAsked = generateRandomNumber1to3();
	boolean rightAnswer = false;
	//if ej har kursbok
	if(!checkBackpack(avatar)){ 
	    if(questionToBeAsked == 1) { 
		ArrayList<String> q1 = this.course.getQuestionAndAnswers(1); 
		rightAnswer = askQuestion(q1);
	    } 
	    if(questionToBeAsked == 2) {
		ArrayList<String> q2 = this.course.getQuestionAndAnswers(2);
		rightAnswer = askQuestion(q2);
	    } 
	    else{ 
		ArrayList<String> q3 = this.course.getQuestionAndAnswers(3); 
		rightAnswer = askQuestion(q3);
	    } 
	}
	//if har kursbok
	else { 
	    if(questionToBeAsked == 1) { 
		ArrayList<String> q1 = this.course.getQuestionAndAnswers(1); 
		rightAnswer = askQuestionWith2Answers(q1);
	    } 
	    if(questionToBeAsked == 2) {
		ArrayList<String> q2 = this.course.getQuestionAndAnswers(2);
		rightAnswer = askQuestionWith2Answers(q2);
	    } 
	    else{ 
		ArrayList<String> q3 = this.course.getQuestionAndAnswers(3); 
		rightAnswer = askQuestionWith2Answers(q3);
	    } 
	} 
	return rightAnswer; 
    }

    public boolean askQuestionWith2Answers(ArrayList<String> questionAndAnswers){
	String question = questionAndAnswers.get(0); 
	String rightAnswer = questionAndAnswers.get(1); 
	String falseAnswer1 = questionAndAnswers.get(2);
	String falseAnswer2 = questionAndAnswers.get(3);
	int positionOfAnswers = generateRandomNumber1to2();
	System.out.println(question);
	if(positionOfAnswers == 1){ 
	    System.out.print("\na. " + rightAnswer + "\nb. " + falseAnswer1);
	    String answer = readInput("a","b");
	    if(answer == "a") return true; 
	    else return false;
	} 
	else{ 
	    System.out.print("\na. " + falseAnswer2 + "\nb. " + rightAnswer); 
	    String answer = readInput("a","b");
	    if(answer == "b") return true; 
	    else return false;
	} 
    }  

    public int generateRandomNumber1to2(){ 
	Random random = new Random(); 
	int randomNumber =  random.nextInt(2);//the 2 is exclusive but inclusive 0
	return randomNumber + 1;
    }

    public boolean askQuestion(ArrayList<String> questionAndAnswers){ 
	String question = questionAndAnswers.get(0); 
	String rightAnswer = questionAndAnswers.get(1); 
	String falseAnswer1 = questionAndAnswers.get(2);
	String falseAnswer2 = questionAndAnswers.get(3);
	//försök till att randomizea ordningen säkert fett sämst 
	int positionOfAnswers = generateRandomNumber1to3();
	System.out.println(question);
	if(positionOfAnswers == 1){ 
	    System.out.print("\na. " + rightAnswer + "\nb. " + falseAnswer1 + "\nc. " + falseAnswer2);
	    String answer = readInput("a","b","c");
	    if(answer == "a") return true; 
	    else return false;
	} 
	if(positionOfAnswers == 2){ 
	    System.out.print("\na. " + falseAnswer1 + "\nb. " + rightAnswer + "\nc. " + falseAnswer2); 
	    String answer = readInput("a","b","c");
	    if(answer == "b") return true; 
	    else return false;
	} 
	else { 
	    System.out.print("\na. " + falseAnswer1 + "\nb. " + falseAnswer2 + "\nc. " + rightAnswer); 
	    String answer = readInput("a","b","c");
	    if(answer == "c") return true; 
	    else return false;
	}
    }

    public String readInput(String a, String b){ 
	String answer = "";
	while(true){ 
	    Scanner sc = new Scanner(System.in);
	    answer = sc.next(); 
	    if((answer == a)||(answer==b)) break; 
	    else System.out.print("Valid inputs are" + a + b);    
	} 
	return answer; 
    }

    public String readInput(String a, String b, String c){ 
	String answer = "";
	while(true){
	    Scanner sc = new Scanner(System.in);
	    answer = sc.next(); 
	    if((answer == a)||(answer==b)||(answer == c)) break; 
	    else System.out.print("Valid inputs are" + a + b + c);
	}
	return answer;
    }
	
    public boolean checkBackpack(Avatar avatar){ 
	Backpack b = avatar.getBackpack();
	return b.checkCourse(this.course);
    }
	
    public int generateRandomNumber1to3(){
	Random random = new Random(); 
	int randomNumber =  random.nextInt(3);//the 3 is exclusive but inclusive 0
	return randomNumber + 1;
    } 

    public boolean searchListForName(List<Course> list){ 
	Iterator<Course> iterator = list.iterator(); 
	while(iterator.hasNext()){ 
	    if(iterator.next().getName().equals(this.course.getName())){ 
		return true; 
	    } 
	} 
	return false; 
    }
	
    public boolean percent(int between0and100){ 
	Random random = new Random(); 
	int randomNumber = random.nextInt(100);
	if(randomNumber < between0and100) return true; 
	else return false;
    } 
    
}

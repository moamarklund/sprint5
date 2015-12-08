import java.util.*; 

public class Student extends Creature{ 

    //Attribut 
    private String name; 
    private Course doneCourse; 
    private Books book; 

    //Konstruktor 
    public Student(String name, Books book, Course course){ 
	super(course); 
	this.name = name; 
	this.book = book; 
	this.doneCourse = book.getCourse();
    } 


    //Metoder 
    public void talk(Avatar avatar){ 
	System.out.print("Hi! My current course is" + this.course + "and my done course is" + this.doneCourse +". If you have the book for my current course, we can trade! trade my <name> or <no>");
	ArrayList<String> answer = readSpecialInput("trade ","no"); 
	if(answer.get(0) == "no") return; 
	else if(answer.get(0) == "trade ")trade(avatar, answer.get(1));
	}  

    public void trade(Avatar avatar, String name){ 
	if(name == this.name) { 
	    //om boken finns i avatarens backpack 
	    if(checkBackpack(avatar)) { //kolla om avataren är registerad på kursen?
		System.out.print("Would you like the book:" + this.book + "or the right answer to the teachers question? <b> or <r>"); 
		String answer = readInput("b","r");
		//studenten ger avataren sin gamla kursbok och uppdatera studentens bok 
		if (answer == "b") {
		    Backpack b = avatar.getBackpack(); 
		    b.pack(this.book); 
		    this.book = removeBookForCourse(avatar);
		} 
		//eller uppdatera course rightanswer till true och uppdatera studentens bok
		if (answer == "r") { 
		    this.course.setRightAnswer(true);
		    this.book = removeBookForCourse(avatar);
		}
	    }
	} 
	else System.out.print("Wrong name!!!");
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

    public Books removeBookForCourse(Avatar avatar){ 
	Backpack b = avatar.getBackpack();
	return b.removeBookForCourse(this.course);
    }

    public boolean checkBackpack(Avatar avatar){ 
	Backpack b = avatar.getBackpack();
	return b.checkCourse(this.course);
    }
	
    public ArrayList<String> readSpecialInput(String a, String b){ 
	String answer = "";
	String name = ""; 
	ArrayList<String> list = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	while(true){ 
	    answer = sc.next(); 
	    if(answer.length() >= a.length()) name = answer.substring(a.length(),answer.length());
	    if(answer.length() >= a.length()) answer = answer.substring(0,a.length()); //??? 
	    if((answer == a)||(answer== b)) break; 
	    else System.out.print("Valid inputs are" + a + "<student's name> ," + b);    
	}  
	if(a == answer) { 
	    list.add(0, answer); 
	    list.add(1, name);
	} 
	if(b == answer) { 
	    list.add(0, answer); 
	}
	return list; 
    } 
  
}
    


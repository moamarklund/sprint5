import java.util.*; 

public class Teacher extends Creature{

    //Konstruktor 
    public Teacher(Course course){ 
	super(course); 
    } 

    //Metoder 
    void talk(Avatar avatar){ 
	List<Course> list = avatar.getUnfinishedCourses();
    //if oavklarad kurs- 75% chans för fråga, flervalsfråga med tre alternativ, om bok två alternativ 
	if(searchListForName(list) && percent(75)); 
	//   int questionToBeAsked = generateRandomNumber1to3();
	    //if ej har kursbok 
	    //if har kursbok
    //om rätt svar lägg till coursen i finishedCourse listan, ta bort ur unfinishedCourse och lägg till HP
	
	List<Course> list2 = avatar.getFinishedCourses();
    //if avklarad kurs- 50% chans för fråga,flervalsfråga med tre alternativ,om bok två alternativ 
	if(searchListForName(list2) && percent(50));
    //om fel svar lägg till kursen i unfinishedcourses, ta bort ur finishedCourses och ta bort HP

    //if ej avklarad/oavklarad kurs 
	//then enroll dvs lägg till i unfinishedCourses
	//IO hantering??? enroll + kursens namn
    } 

	/*   public boolean checkBookName(Avatar avatar){
	if(avatar.getBook().getName().equals(this.course.getBook().getName())) return true; 
	else return false;
	}*/

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

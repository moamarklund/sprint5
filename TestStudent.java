import org.junit.*; 
import static org.junit.Assert.assertEquals;
import java.util.*; 


public class TestStudent{ 

    @Test 
    public void test_removeBookForCourse(){
	Student s = createStudent();
	Avatar a = new Avatar();
	a.getBackpack().pack(s.getBook());
	Course c = s.getCourse();
	Books book = s.removeBookForCourse(a);
	//System.out.println();
	Course c2 = book.getCourse();
	assertEquals(c,c2); 
    }

    @Test
    public void test_false_checkBackpack(){ 
	Avatar a = new Avatar(); 
	Student s = createStudent(); 
	assertEquals(s.checkBackpack(a), false);
    } 

    @Test 
    public void test_true_checkBackpack(){ 
	Avatar a = new Avatar(); 
	Student s = createStudent();
	Books b = s.getBook();
	a.getBackpack().pack(b);
	assertEquals(s.checkBackpack(a), true);
    }	

	
    public Student createStudent(){
	ArrayList<String> qa = fixQA(); 
	Course c = new Course("Dödsfin kurs",qa,qa,qa);
	Books b = new Books("Bananboken", "Vem vet",2015,1,c);
	Student s = new Student("BananerIPyjamas",b,c);
	return s;
    } 

    public ArrayList<String> fixQA(){ 
	ArrayList<String> qa = new ArrayList<String>(); 
	qa.add(0,"Vem vad varför?"); 
	qa.add(1,"Jag");
	qa.add(2,"Du"); 
	qa.add(3,"Hen");
	return qa;
    }
}
import org.junit.*; 
import static org.junit.Assert.assertEquals;
import java.util.*; 


public class TestStudent{ 

    @Test 
    public void test_removeBookForCourse(){
	Student s = createStudent();
	Avatar a = new Avatar();
	a.getBackpack().pack(s.getBook());
	Course c = s.getCourse();
	Books book = s.removeBookForCourse(a);
	//System.out.println();
	Course c2 = book.getCourse();
	assertEquals(c,c2); 
    }

    @Test
    public void test_false_checkBackpack(){ 
	Avatar a = new Avatar(); 
	Student s = createStudent(); 
	assertEquals(s.checkBackpack(a), false);
    } 

    @Test 
    public void test_true_checkBackpack(){ 
	Avatar a = new Avatar(); 
	Student s = createStudent();
	Books b = s.getBook();
	a.getBackpack().pack(b);
	assertEquals(s.checkBackpack(a), true);
    }	

	
    public Student createStudent(){
	ArrayList<String> qa = fixQA(); 
	Course c = new Course("Dödsfin kurs",qa,qa,qa);
	Books b = new Books("Bananboken", "Vem vet",2015,1,c);
	Student s = new Student("BananerIPyjamas",b,c);
	return s;
    } 

    public ArrayList<String> fixQA(){ 
	ArrayList<String> qa = new ArrayList<String>(); 
	qa.add(0,"Vem vad varför?"); 
	qa.add(1,"Jag");
	qa.add(2,"Du"); 
	qa.add(3,"Hen");
	return qa;
    }
}

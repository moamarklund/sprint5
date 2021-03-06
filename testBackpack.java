import org.junit.*;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import java.util.*; 

public class testBackpack extends TestCase {
    
    @Test
    public void testPack(){
	Backpack b = new Backpack();
	Item o1 = new Item("hej",1);
	b.pack(o1);
	assertEquals(b.getTotalObjects(), 1);
    } 

    @Test
    public void testDrop(){
	Backpack b = new Backpack();
	Item o1 = new Item("hej",1);
	b.pack(o1);
	b.drop(o1);
	assertEquals(b.getTotalObjects(), 0);
    }  

    @Test
    public void testCheckCourse(){
	Backpack b = new Backpack();
	ArrayList<String> qa = fixQA(); 
	Course c = new Course("Dödsfin kurs",qa,qa,qa);
       	Books book = new Books("Bananboken", "Vem vet",2015,1,c);
	b.pack(book);
	assertEquals(b.checkCourse(c),true);
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

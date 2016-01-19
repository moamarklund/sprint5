import java.util.*;
import org.junit.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;


public class testBooks extends TestCase {
    public static final ArrayList<String> qa1= new ArrayList<String>(Arrays.asList("Vad fan är en statisk variabel?", "En variabel som tillhör klassen och inte objekten", "Ingen jävla aning", "Fråga någon i foobar"));
    public static final ArrayList<String> qa2= new ArrayList<String>(Arrays.asList("Vad babblar Elias och Tobias om EGENTLIGEN?", "heybaberiba", "bananer i pyjamas", "bolibompa"));
    public static final ArrayList<String> qa3= new ArrayList<String>(Arrays.asList("Vem är snyggaste labbassen?", "Henrik", "Han med tofsboll", "Mikael"));
    public static final Course course = new Course("IOOPM", qa1, qa2, q3, 20);
    public static final Books book = new Books("Testbok", "Testförfattare", 2014, 3, course); 

    @Test
    public void testWeight(){
	System.out.println("Testing weight");
	assertTrue(book.getWeight() == 3);
    }

    @Test
    public void testName(){
	System.out.println("Testing name");
	assertEquals(book.getName(), "Testbok");
    }

    @Test
    public void testCourse(){
	System.out.printn("Testing course");
	assertEquals(book.getCourse().getName(), "IOOPM"); 
    }
}

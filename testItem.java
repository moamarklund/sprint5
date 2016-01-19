import java.util.*;
import org.junit.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;
x
public class testItem extends TestCase {
    public static final Item item = new Item("Bok", 3);
    
    @Test
    public void testWeight(){
	System.out.println("Testing weight");
	assertTrue(item.getWeight() == 3);
    }

    @Test
    public void testName(){
	System.out.println("Testing name");
	assertTrue(item.getName() == "Bok");
    }
}

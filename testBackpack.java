import org.junit.*;
import junit.framework.TestCase;

public class testBackpack extends TestCase {
    Backpack b = new Backpack();
    Objects o1 = new Objects();

    protected void setUp(){
	b.weight = 3;
	b.totalObjects = 0;
	//o1 = ("Bok"; 3);
	b.pack(o1);
    }
    
    @Test
    public void testPack(){
	assertEquals(b.totalObjects = 1);
    }
    /*
    System.out.println(o1);
    System.out.println(b.totalObjects);
    System.out.println(o1.getWeight());
    b.pack(o1);
    b.pack(o2);
    b.pack(o3);
    b.pack(o4);
    b.pack(o5);
       

    System.out.println(b.weight);
    System.out.println(b.totalObjects);

    //b.drop(o1);
    b.inventory();
    System.out.println(b.totalObjects);
    System.out.println(b.weight);
    */
    

}
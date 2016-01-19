import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Backpack {
    private final ArrayList<Item> objectlist;
    private int weight;
    private int totalObjects; 
    
    public Backpack(){
	objectlist = new ArrayList<Item>();
	this.weight = 0;
	this.totalObjects = 0;
    }
    
    public void pack(Item item){
	if(weight >= 10){
	    System.out.println("Backpack full, drop some objects before packing");
	}
	else{
	    //  if(this.objectlist != null){
	    int i = (weight += item.getWeight());
	    if(i < 10){
		objectlist.add(item); 
		totalObjects++;
	    }
	    else{
		System.out.println("Backpack full, drop some objects before packing");
		weight -= item.getWeight();   
	    }
	}
	/*    else{
	      totalObjects++;
	      weight += item.getWeight();
	      }*/
    }
    
    
    public void drop(Item item){
	weight -= item.getWeight();
	objectlist.remove(item);
	totalObjects--;   
    }
    
    public boolean checkCourse(Course c){ 
	Iterator<Item> iterator = objectlist.iterator(); 
	while(iterator.hasNext()){ 
	    if(iterator.next() instanceof Books){
		if(((Books) iterator.next()).getCourseName().equals(c.getName())){ 
		    return true; 
		}
	    } 
	} 
	return false; 
    } 

    public Books removeBookForCourse(Course c){ 
	Iterator<Item> iterator = objectlist.iterator(); 
	Books book = new Books("","",0,0,c);//endast för att detta inte kan va i loopen
	while(iterator.hasNext()){ 
	    if(iterator.next() instanceof Books){
		if(((Books) iterator.next()).getCourseName().equals(c.getName())){ 
		    book =  ((Books) iterator.next());
		    break;
		}
	    } 
	} 
	drop(book);
	return book;
    }
	
    public void inventory(){
	if(totalObjects == 0){ 
	    System.out.println("The backpack is empty!"); 
	}
	int i = 1;
	Iterator<Item> iterator = objectlist.iterator();
	  System.out.println("==================");
	  while(iterator.hasNext()){
	      
	      System.out.println(i + ". " + iterator.next().getName());
	      
	      i++;
	  }
	  
	  System.out.println("==================");
    }
    
    
	
public static void main(String [] args){
    Backpack b = new Backpack();
    Item o1 = new Item("Bok", 2);
    Item o2 = new Item("Nyckel", 3);
    Item o3 = new Item("Nyckel", 3);
    Item o4 = new Item("Nyckel", 7);
    Item o5 = new Item("Nyckel", 3);
    
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
    }

}
   



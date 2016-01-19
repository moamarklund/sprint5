import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Represents a backpack with items 
 * @param objectlist A list of all the items in the backpack
 * @param weight The total weight of the backpack
 * @param totalObjects The number of items in the backpack 
 **/
public class Backpack {
    private final ArrayList<Item> objectlist;
    private int weight;
    private int totalObjects; 

    
    /**
     * Creates a backpack
     **/
    public Backpack(){
	objectlist = new ArrayList<Item>();
	this.weight = 0;
	this.totalObjects = 0;
    }

    
    /**
     * Packs an item to the backpack
     * @param item The item to be packed
     **/
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
    
    
    /**
     * Drops an item from the backpack
     * @param item The item to be dropped from the backpack
     **/
    public void drop(Item item){
	weight -= item.getWeight();
	objectlist.remove(item);
	totalObjects--;   
    }

    
    /**
     * Takes a course and checks if the book for that course is in the backpack
     * @param c the course to look for
     * @return true if the book was in the backpack and false otherwise
     **/
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

    /**
     * Drops a book for a certain course
     * @param c The course to drop the book for
     * @return The book that was dropped
     **/
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

    
    /**
     * Prints out all of the items in the backpack
     **/
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
    


}

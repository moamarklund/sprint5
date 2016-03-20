/**
 * @author Malin Englund and Moa Marklund
 * @since 2015/2016
 */

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
     *@brief The constructor creates a backpack
     */
    public Backpack(){
	objectlist = new ArrayList<Item>();
	this.weight = 0;
	this.totalObjects = 0;
    }

    public void setWeight(int weight){
	this.weight = weight; 
    } 

    public void setTotalObjects(int a){ 
	this.totalObjects = a; 
    }

    public int getTotalObjects(){
	return this.totalObjects; 
    }

    public Item getFirstObjectList(){
	return this.objectlist.get(0);
    }
    
    /**
     *The function adds item to the backpack
     *@param item is going to be added 
     */
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
     *Drops the specified item 
     *@param item is going to be removed
    **/
    public void drop(Item item){
	weight -= item.getWeight();
	objectlist.remove(item);
	totalObjects--;   
    }

 
    /** 
     *The function checks if the book with the belonging course c is in the backpack. 
     *@param c is the course that belongs to the book that is going to be checked 
     *@return true if the book was found else false
     */
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
     *The function removes the book for specified course.
     *@param c is the course for which the function is going to remove the belonging book
     *@return The removed book if it was found and removed else an "empty" book
     */ 
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
     *List the all the items in the backpack.
     */ 	
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



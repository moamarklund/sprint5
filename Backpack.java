import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Backpack {
    private final ArrayList<Objects> objectlist;
    private int weight;
    private int totalObjects; 
    
    public Backpack(){
	objectlist = new ArrayList<Objects>();
	this.weight = 0;
	this.totalObjects = 0;
    }
    
    public void pack(Objects object){
	if(weight >= 10){
	    System.out.println("Backpack full, drop some objects before packing");
	}
	else{
	    if(this.objectlist != null){
		int i = (weight += object.getWeight());
		if(i < 10){
		objectlist.add(object); 
		totalObjects++;
		}
		else{
		    System.out.println("Backpack full, drop some objects before packing");
		    weight -= object.getWeight();   
		}
	    }
	    else{
		totalObjects++;
		weight += object.getWeight();
	    }
	}
    }
    
    public void drop(Objects object){
	weight -= object.getWeight();
	objectlist.remove(object);
	totalObjects--;   
    }
    
    public boolean checkCourse(Course c){ 
	Iterator<Objects> iterator = objectlist.iterator(); 
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
	Iterator<Objects> iterator = objectlist.iterator(); 
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
	int i = 1;
	Iterator<Objects> iterator = objectlist.iterator();
	  System.out.println("==================");
	  while(iterator.hasNext()){
	      
	      System.out.println(i + ". " + iterator.next().getName());
	      
	      i++;
	  }
	  
	  System.out.println("==================");
    }
    
    
	
public static void main(String [] args){
    Backpack b = new Backpack();
    Objects o1 = new Objects("Bok", 2);
    Objects o2 = new Objects("Nyckel", 3);
    Objects o3 = new Objects("Nyckel", 3);
    Objects o4 = new Objects("Nyckel", 7);
    Objects o5 = new Objects("Nyckel", 3);
    
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
   



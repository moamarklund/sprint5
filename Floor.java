import java.util.*;
    
public class Floor{
    private Room first; 


    public Floor(){
	this.first = null;
    }
 
    public class Room{
	private final ArrayList <Objects> roomObjects;
	private String name;
	private boolean doorOpen;
	private Room north;
	private Room west;
	private Room east;
	private Room south;

       
        public Room(){
	roomObjects = new ArrayList<Objects>();
	this.name = name;
	this.doorOpen = false;
	this.north = null;
	this.west = null;
	this.east = null;
	this.south = null; 
	}
    }

    public class Hallway{
	private Room north;
	private boolean openNorth;
	private Room south;
	private boolean openSouth;
	private Hallway west;
	private boolean openWest;
	private Hallway east;
	private boolean openEast;


        public Hallway(){
	    this.north = null;
	    this.openNorth = false;
	    this.south = null;
	    this.openSouth = false;
	    this.west = null;
	    this.openWest = false;
	    this.east = null;
	    this.openEast = false;
	}
    }

    

    
}


/*public class Room{
    private String name;
    private boolean doorOpen;
    private boolean north;
    private boolean east;
    private boolean west;
    private boolean south;
    private ArrayList<Objects> objectlist;

    public Room(){
	this.name = name;
	this.doorOpen = false;
	this.north = false;
	this.east = false;
	this.west = false;
	this.south = false;
	objectlist = new ArrayList<Objects>();
    }
	     
    public void createDoorNorth(){
	north = false;
	east = false;
	west = false;
	south = true;
	doorOpen = false; 
	
    }

     public void createDoorSouth(){
	north = true;
	east = false;
	west = false;
	south = false;
	doorOpen = false; 
	
    }

    public void createHallway(){
	north = 
    }
    public boolean checkDoor() {
	if(doorOpen){
	    return true
	}
	else{
	    return false;
	    
	}
    }

    
}
*/

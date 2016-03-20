
import java.util.*;
/**
 * Represents a room 
 * @param roomItems The items in the room
 * @param student The student in the room
 * @param teacher The teacher in the room
 * @param name The name of the room
 * @param north The room in the north direction
 * @param doorOpenNorth A boolean representing if the north room is open 
 * @param south The room in the south direction
 * @param doorOpenSouth A boolean representing if the south room is open 
 * @param east The room in the east direction
 * @param doorOpenEast A boolean representing if the east room is open 
 * @param west The room in the west direction
 * @param doorOpenWest A boolean representing if the west room is open 
 **/
public class Room{
    private final ArrayList <Item> roomItems;
    private Student student;
    private Teacher teacher;
    private String name;
    private Room north;
    private boolean doorOpenNorth;
    private Room south;
    private boolean doorOpenSouth;
    private Room east;
    private boolean doorOpenEast; 
    private Room west;
    private boolean doorOpenWest;

    /**
     * Creates a room 
     * @param name The name of the room
     * @param north The room in the north direction
     * @param doorOpenNorth A boolean representing if the north room is open 
     * @param south The room in the south direction
     * @param doorOpenSouth A boolean representing if the south room is open 
     * @param east The room in the east direction
     * @param doorOpenEast A boolean representing if the east room is open 
     * @param west The room in the west direction
     * @param doorOpenWest A boolean representing if the west room is open 
     * @param student The student in the room
     * @param teacher The teacher in the room
     * @param roomItems The items in the room
     **/
    public Room(String name, Room north, Room south, Room east, Room west, boolean doorNorth, boolean doorSouth, boolean doorEast, boolean doorWest, Teacher teacher, Student student, ArrayList<Item> items){
	this.roomItems = items;
	this.student = student;
	this.teacher = teacher;
	this.name = name;
	this.north = north;
	this.doorOpenNorth = doorNorth;
	this.south = south;
	this.doorOpenSouth = doorSouth;
	this.east = east;
	this.doorOpenEast = doorEast;
	this.west = west;
	this.doorOpenWest = doorWest;
    } 

    /**
     * Creates a room with fixed room settings 
     * @param name The name of the room 
     * @param student The student in the room
     * @param teacher The teacher in the room
     * @param roomItems The items in the room
     **/
    public Room(String name, Teacher teacher, Student student,ArrayList<Item> items){ 
	this(name, null, null, null, null, false, false, false, false, teacher, student, items); 
    }

    /**
     * Checks the items in a room
     * @return A list with the items in the room 
     **/
    public ArrayList<Item> getItemsinRoom(){
	return this.roomItems;
    }

    /**
     * Sets if a door is locked or not
     * @param lock false if the door is locked, true if it is open
     **/
    public void setDoorSouth(Boolean lock){
	this.doorOpenSouth = lock;
    }
    /**
     * Sets if a door is locked or not
     * @param lock false if the door is locked, true if it is open
     **/
    public void setDoorNorth(Boolean lock){
	this.doorOpenNorth = lock;
    } /**
     * Sets if a door is locked or not
     * @param lock false if the door is locked, true if it is open
     **/
    public void setDoorEast(Boolean lock){
	this.doorOpenEast = lock;
    } /**
     * Sets if a door is locked or not
     * @param lock false if the door is locked, true if it is open
     **/
    public void setDoorWest(Boolean lock){
	this.doorOpenWest = lock;
    } 
    /**
     * Sets a room in a direction to a decided room
     * @param set The room to set to 
     **/
    public void setRoomNorth(Room set){ 
	this.north = set; 
    } 
   /**
     * Sets a room in a direction to a decided room
     * @param set The room to set to 
     **/
    public void setRoomSouth(Room set){ 
	this.south = set; 
    } 
   /**
     * Sets a room in a direction to a decided room
     * @param set The room to set to 
     **/
    public void setRoomEast(Room set){ 
	this.east = set; 
    } 
   /**
     * Sets a room in a direction to a decided room
     * @param set The room to set to 
     **/
    public void setRoomWest(Room set){ 
	this.west = set; 
    } 

    /**
     * Checks which room is in a certain direction
     * @return The room in that direction
     **/
    public Room getRoomNorth(){ 
	return this.north; 
    } 

    /**
     * Checks which room is in a certain direction
     * @return The room in that direction
     **/
    public Room getRoomSouth(){ 
	return this.south; 
    } 

    /**
     * Checks which room is in a certain direction
     * @return The room in that direction
     **/
    public Room getRoomEast(){ 
	return this.east; 
    } 

    /**
     * Checks which room is in a certain direction
     * @return The room in that direction
     **/
    public Room getRoomWest(){ 
	return this.west; 
    }
    
    /**
     * Checks if a door in a direction is open
     * @return False if the door is locked otherwise true
     **/
    public Boolean getDoorSouth(){
	return this.doorOpenSouth; 
    }
    
    /**
     * Checks if a door in a direction is open
     * @return False if the door is locked otherwise true
     **/
    public Boolean getDoorNorth(){
	return this.doorOpenNorth; 
    }

     /**
     * Checks if a door in a direction is open
     * @return False if the door is locked otherwise true
     **/
    public Boolean getDoorWest(){
	return this.doorOpenWest; 
    }

     /**
     * Checks if a door in a direction is open
     * @return False if the door is locked otherwise true
     **/
    public Boolean getDoorEast(){
	return this.doorOpenEast; 
    }
    /**
     * Checks the name of a room
     * @return The name of the room 
     **/
    public String getName(){ 
	return this.name; 
    } 

    /**
     * Checks the student in the room
     * @return The student in the room
     **/
    public Student getStudent(){ 
	return this.student; 
    } 

    /**
     * Checks the teacher in the room
     * @return The teacher in the room
     **/
    public Teacher getTeacher(){ 
	return this.teacher; 
    } 

    /**
     * Checks if a name is equal to the name of the student in the room 
     * @return True if they were equal, otherwise false
     **/
    public boolean checkStudentName(String namee){ 
	return namee.equals(student.getName()); 
    }
    /**
     * Creates a string of a room 
     * @return A string represeting a room 
     **/
    public String toString(){ 
	Room[] rooms = {north,south,east,west}; 
	boolean[] doors = {doorOpenNorth,doorOpenSouth,doorOpenEast,doorOpenWest};
	String n = ""; 
	String s = ""; 
	String e = ""; 
	String w = "";
	String[] hola ={n,s,e,w};
	for(int i = 0; i < rooms.length; i++){ 
	    if(rooms[i] == null){ 
		hola[i] = "X"; 
	    } 
	    if(rooms[i] != null && doors[i]){ 
		hola[i] = "The door is open to room: " + rooms[i].name;
	    } 
	    else if (rooms[i] != null && !doors[i]){ 
		hola[i] = "The door is locked to room: " + rooms[i].name;
	    }    
	}
       
	String studentish = ""; 
	if(student != null) { 
	    studentish = "\nHär finns studenten " + this.student.toString(); 
	} 
	else{ 
	    studentish = "\nDet finns ingen student här!"; 
	}
	return "\nDu är i : " + name + "\nNord : " + hola[0] + "\nSyd : " + hola[1] + "\nÖst : " + hola[2] + "\nVäst : " + hola[3] + "\nAntal nycklar som finns i rummet : " + roomItems.size() + studentish; 
    }
}

import java.util.*;

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

    public Room(String name, Teacher teacher, Student student,ArrayList<Item> items){ 
	this(name, null, null, null, null, false, false, false, false, teacher, student, items); 
    }

    public void setRoomNorth(Room set){ 
	this.north = set; 
    } 

    public void setRoomSouth(Room set){ 
	this.south = set; 
    } 

    public void setRoomEast(Room set){ 
	this.east = set; 
    } 

    public void setRoomWest(Room set){ 
	this.west = set; 
    } 

    public Room getRoomNorth(){ 
	return this.north; 
    } 

    public Room getRoomSouth(){ 
	return this.south; 
    } 

    public Room getRoomEast(){ 
	return this.east; 
    } 

    public Room getRoomWest(){ 
	return this.west; 
    } 

    public String getName(){ 
	return this.name; 
    } 
    
    public Student getStudent(){ 
	return this.student; 
    } 

    public Teacher getTeacher(){ 
	return this.teacher; 
    } 

    public boolean checkStudentName(String namee){ 
	return namee.equals(student.getName()); 
    }

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
		hola[i] = "The door is open to room : " + rooms[i].name;
	    } 
	    else if (rooms[i] != null && !doors[i]){ 
		hola[i] = "The door is closed to room : " + rooms[i].name;
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

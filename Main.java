import java.util.*;



public class Main{ 

    public Main(){ 
    } 

    public static void main(String args[]){
	Main m = new Main();
	World w = new World();
	Avatar a = w.getAvatar();
	Room currentRoom = w.getFirst();
	while(true){ 
	    //kolla sphinxen - går ur loopen
	    //printa rummet
	    //	    System.out.print("\033[2J\033[;H");
	    System.out.println("=============== PollaxMUD ================");
	    System.out.println(currentRoom);
	    //kommandon - inläsning från användaren: 
	    String input = m.readInput("go north","go south","go east","go west","inventory","pick up","drop","check courses","talk","trade","graduate","enroll", "unlock south", "unlock west", "unlock east", "unlock north" ); 
	    //System.out.println(input);
	    //go väderstreck - uppdatera currentRoom 
	    if(input.equals("go north")){ 
		    if(currentRoom.getRoomNorth() != null){
			if(currentRoom.getRoomNorth().getDoorNorth() != false){
			//kolla nycklar o shit
			    currentRoom = currentRoom.getRoomNorth(); }
			else {
			    System.out.println("The door is locked");
			}
			//kolla nycklar o shit
			currentRoom = currentRoom.getRoomNorth(); 
		    } 
		    else { 
			System.out.println("There is no room in the north direction");
		    } 
		}
	    else if(input.equals("go south")){ 
		    if(currentRoom.getRoomSouth() != null){
			if(currentRoom.getRoomSouth().getDoorSouth() != false){
			//kolla nycklar o shit
			    currentRoom = currentRoom.getRoomSouth(); }
			else {
			    System.out.println("The door is locked");
			}
		    } 
		    else { 
			System.out.println("There is no room in the south direction");
		    } 
		}
	    else if(input.equals("go east")){ 
		    if(currentRoom.getRoomEast() != null){ 
			if(currentRoom.getRoomEast().getDoorEast() != false){
			//kolla nycklar o shit
			    currentRoom = currentRoom.getRoomEast(); }
			else {
			    System.out.println("The door is locked");
			}
		    } 
		    else { 
			System.out.println("There is no room in the east direction");
		    } 
	    } 
	    else if(input.equals("go west")){ 
		    if(currentRoom.getRoomWest() != null){ 
			if(currentRoom.getRoomWest().getDoorWest() != false){
			//kolla nycklar o shit
			    currentRoom = currentRoom.getRoomWest(); }
			else {
			    System.out.println("The door is locked");
			}
		    } 
		    else { 
			System.out.println("There is no room in the west direction");
		    } 
	    }
	
	    else if(input.equals("unlock south")){
		    Room room = currentRoom.getRoomSouth();
		    if(room != null){
			if(room.getDoorSouth() == false){
			    if(a.getBackpack().getTotalObjects() != 0){
				Item key = a.getBackpack().getFirstObjectList();
				a.getBackpack().drop(key);
				room.setDoorSouth(true);
			    }
			    else{
				System.out.println("You don´t have any keys to use");
			    }
			 
			}
			else{
			    System.out.println("The door is already open");
			}
		    }
		    else{
			System.out.println("There is no room in the south direction");
		    }
		       
		}

	      else if(input.equals("unlock east")){
		    Room room = currentRoom.getRoomEast();
		    if(room != null){
			if(room.getDoorEast() == false){
			    if(a.getBackpack().getTotalObjects() != 0){
				Item key = a.getBackpack().getFirstObjectList();
				a.getBackpack().drop(key);
				room.setDoorEast(true);
			    }
			    else{
				System.out.println("You don´t have any keys to use");
			    }
			 
			}
			else{
			    System.out.println("The door is already open");
			}
		    }
		    else{
			System.out.println("There is no room in the east direction");
		    }
		       
		}
	       else if(input.equals("unlock west")){
		    Room room = currentRoom.getRoomWest();
		    if(room != null){
			if(room.getDoorWest() == false){
			    if(a.getBackpack().getTotalObjects() != 0){
				Item key = a.getBackpack().getFirstObjectList();
				a.getBackpack().drop(key);
				room.setDoorWest(true);
			    }
			    else{
				System.out.println("You don´t have any keys to use");
			    }
			 
			}
			else{
			    System.out.println("The door is already open");
			}
		    }
		    else{
			System.out.println("There is no room in the east direction");
		    }
		       
		}

	       else if(input.equals("unlock north")){
		    Room room = currentRoom.getRoomNorth();
		    if(room != null){
			if(room.getDoorNorth() == false){
			    if(a.getBackpack().getTotalObjects() != 0){
				Item key = a.getBackpack().getFirstObjectList();
				a.getBackpack().drop(key);
				room.setDoorNorth(true);
			    }
			    else{
				System.out.println("You don´t have any keys to use");
			    }
			 
			}
			else{
			    System.out.println("The door is already open");
			}
		    }
		    else{
			System.out.println("There is no room in the east direction");
		    }
		       
		}
	    
	    //inventory
	    else if(input.equals("inventory")){
		Backpack b = a.getBackpack();
		b.inventory();
	    }
	    //kolla kurser
	    else if(input.equals("check courses")){ 
		m.printCourses(a);
	    } 
	    else if(input.equals("graduate")){
		System.out.println("not implemented yet");
		//kolla om sfinxen finns i rummet
	    } 
	    else if(input.substring(0,4).equals("talk")){ 
		//		System.out.println("not implemented yet");
	        String talkPerson = input.substring(5,input.length()); 
		System.out.print(talkPerson);
		if(talkPerson.equals("teacher")){ 
			if(currentRoom.getTeacher() != null){ 
			    Teacher t = currentRoom.getTeacher(); 
			    t.talk(a);
			} 
	        }
		else if(currentRoom.checkStudentName(talkPerson)){
		    Student s = currentRoom.getStudent();
		    s.talk(a); 
		} 
		else { 
		    System.out.println("No such person in the room");
		} 
	    } 
	    //plocka upp saker 
	    else if(input.equals("pick up")){
		ArrayList<Item> Items = currentRoom.getItemsinRoom();
		if(Items.size() != 0){
			Item key = Items.get(0);
			a.getBackpack().pack(key);
			Items.remove(key);
		    }
		else{
		    System.out.println("Det finns inga nycklar i det här rummet");
		}
		
	    } 
	    else if(input.length() >= 6){
		if(input.substring(0,6).equals("enroll")){
		    System.out.println("not implemented yet");
		} 
	    }
	    //dropa saker 
	    else if(input.substring(0,4).equals("drop")){ 
		System.out.println("not implemented yet");
	    }
	    else if(input.substring(0,5).equals("trade")){ 
		System.out.println("not implemented yet");
	    } 
	    else{ 
		System.out.println("OH NOES!!!");
	    }
	}
    } 

    public void printCourses(Avatar a){ 
	List<Course> fc = a.getFinishedCourses();
	List<Course> uc = a.getUnfinishedCourses();
	System.out.println("Finished courses : ");
	for(int i = 0; i < fc.size(); i++){ 
	    System.out.println(fc.get(i)); 
	} 
	System.out.println("Unfinished courses : "); 
	for(int j = 0; j < uc.size(); j++){ 
	    System.out.println(uc.get(j)); 
	} 
    }

    public String readInput(String gn, String gs, String ge, String gw, String i, String pu, String d, String cc, String ta, String tr, String gr, String e, String s, String w, String ea, String n){ 
	String answer = "";
	while(true){ 
	    Scanner sc = new Scanner(System.in);
	    answer = sc.nextLine(); 
	    boolean breakLoop = false;
	    if((answer.equals(gn)) || (answer.equals(gs)) || (answer.equals(ge)) || (answer.equals(gw)) || (answer.equals(i)) || (answer.equals(cc)) || answer.equals(gr)) { 
		breakLoop = true;
	    }
	    if((answer.equals(ea)) || (answer.equals(w)) || (answer.equals(n)) || (answer.equals(s))) { breakLoop = true;   
	    }
	    if(answer.length() >= 4){ 
		if(((answer.substring(0,4)).equals(d)) || ((answer.substring(0,4)).equals(ta))) breakLoop = true;
	    } 
	    if(answer.length() >= 5){ 
		if((answer.substring(0,5)).equals(tr)) breakLoop = true; 
	    }
	    if(answer.length() >= 6){ 
		if(answer.substring(0,6).equals(e)) breakLoop = true; 
	    } 
	    if(answer.length() >= 7){
		if((answer.substring(0,7)).equals(pu)) breakLoop = true; 
	    }
	    
	    if(breakLoop == true) break;
	    else System.out.println("Valid inputs are : " + gn + " " + gs + " " + ge + " " + gw+ " "  + i + " " + pu + " "  + d + " "  + cc + " "  + ta+  " "  + tr + " "  + gr + " " + e + " " + s + " " + w + " "+ ea + " " + n);    
	} 
	return answer; 
    }
}

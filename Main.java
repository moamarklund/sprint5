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
	    System.out.println(currentRoom);
	    //kommandon - inläsning från användaren: 
	    String input = m.readInput("go north","go south","go east","go west","inventory","pick up","drop","check courses","talk","trade","graduate","enroll"); 
	    //System.out.println(input);
	    //go väderstreck - uppdatera currentRoom 
	    if(input.equals("go north")){ 
		    if(currentRoom.getRoomNorth() != null){ 
			//kolla nycklar o shit
			currentRoom = currentRoom.getRoomNorth(); 
		    } 
		    else { 
			System.out.println("There is no room in the north direction");
		    } 
		}
	    else if(input.equals("go south")){ 
		    if(currentRoom.getRoomSouth() != null){ 
			//kolla nycklar o shit
			currentRoom = currentRoom.getRoomSouth(); 
		    } 
		    else { 
			System.out.println("There is no room in the south direction");
		    } 
		}
	    else if(input.equals("go east")){ 
		    if(currentRoom.getRoomEast() != null){ 
			//kolla nycklar o shit
			currentRoom = currentRoom.getRoomEast(); 
		    } 
		    else { 
			System.out.println("There is no room in the east direction");
		    } 
	    } 
	    else if(input.equals("go west")){ 
		    if(currentRoom.getRoomWest() != null){ 
			//kolla nycklar o shit
			currentRoom = currentRoom.getRoomWest(); 
		    } 
		    else { 
			System.out.println("There is no room in the west direction");
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
	    else if(input.length() >= 7){
		if(input.substring(0,7) == "pick up"){ 
		    String itemName = input.substring(7,input.length());
		    System.out.println("not implemented yet"); 
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

    public String readInput(String gn, String gs, String ge, String gw, String i, String pu, String d, String cc, String ta, String tr, String gr, String e){ 
	String answer = "";
	while(true){ 
	    Scanner sc = new Scanner(System.in);
	    answer = sc.nextLine(); 
	    boolean breakLoop = false;
	    if((answer.equals(gn)) || (answer.equals(gs)) || (answer.equals(ge)) || (answer.equals(gw)) || (answer.equals(i)) || (answer.equals(cc)) || answer.equals(gr)) { 
		breakLoop = true;
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
	    else System.out.println("Valid inputs are : " + gn + gs + ge + gw + i + pu + d + cc + ta + tr + gr + e);    
	} 
	return answer; 
    }
}

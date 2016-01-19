import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.*;

public class World{ 

    //Attribut 
    private ArrayList<Course> courses; 
    private ArrayList<Teacher> teachers; 
    private ArrayList<Student> students; 
    private ArrayList<Books> books; 
    private ArrayList<Item> keys;
    private ArrayList<Room> rooms;
    private ArrayList<Room> hallways;
    private Avatar avatar;
    private Floor floor;

    public World(){ 
	courses = new ArrayList<Course>(); 
	teachers = new ArrayList<Teacher>();
	students = new ArrayList<Student>();
	books = new ArrayList<Books>();
	keys = new ArrayList<Item>(); 
	rooms = new ArrayList<Room>();
	hallways = new ArrayList<Room>(); 
	createCourses(); 
	createTeachers();
	createBooks();
	createKeys();
	createStudents();
	createFloor();
	createAvatar();
    }
    
    public void readInputCourses() throws IOException {

	List<String> fileText = Files.readAllLines(Paths.get("Course.txt"), Charset.defaultCharset()); //varje rad i filen blir ett element i listan fileText

	String[] parts; //en array som ska hålla orden i en rad 

	String name; 

	String q1;
	String ra1;
	String fOne1; 
	String fTwo1;

	String q2;
	String ra2; 
	String fOne2; 
	String fTwo2; 

	String q3; 
	String ra3; 
	String fOne3; 
	String fTwo3; 

	int HP;

	/*En loop över varje element i listan, dvs varje rad i filen*/
	for(int i = 0; i < fileText.size(); ++i) {    //
	    /*I filen står informationen på formen Boktitel;Författare;År;Volym
	      split-funktionen bryter upp en sträng vid givet tecken (denna gång ;) och
	      lägger in dem i en array.  ...
	    */
	    parts = fileText.get(i).split(";");
    
	    /*... Här sker objektskapandet. För varje rad får vi i arrayen:
	      parts[0] = Boktitel
	      parts[1] = Författare
	      parts[2] = År
	      parts[4] = Volym
	      Detta utnyttjar vi för att skapa objekt som sparas i ett av klassens attribut.
	      Objektet måste antingen sparas i ett sån attribut (dvs typ en global variabel)
	      eller i t.ex. en lista som returneras, annars försvinner infon när stacken rensas.
	    */
	    name = parts[0]; 

	    q1 = parts[1];
	    ra1 = parts[2];
	    fOne1 = parts[3]; 
	    fTwo1 = parts[4];

	    q2 = parts[5];
	    ra2 = parts[6]; 
	    fOne2 = parts[7]; 
	    fTwo2 = parts[8]; 

	    q3 = parts[9]; 
	    ra3 = parts[10]; 
	    fOne3 = parts[11]; 
	    fTwo3 = parts[12]; 

	    HP = Integer.parseInt(parts[13]);
	    
	    
	    Course c = new Course(name, createArrayList(q1,ra1,fOne1,fTwo1), createArrayList(q2,ra2,fOne2,fTwo2), createArrayList(q3,ra3,fOne3,fTwo3), HP);

	    this.courses.add(c);
	} 
    } 

    public ArrayList<String> createArrayList(String question, String rightAnswer, String falseAnswer1, String falseAnswer2){ 
	ArrayList<String> list = new ArrayList<String>(); 
	list.add(0, question); 
	list.add(1, rightAnswer); 
	list.add(2, falseAnswer1); 
	list.add(3, falseAnswer2);
	return list;
    } 

    public void readInputBooks() throws IOException {

	List<String> fileText = Files.readAllLines(Paths.get("Book.txt"), Charset.defaultCharset()); //varje rad i filen blir ett element i listan fileText

	String[] parts; //en array som ska hålla orden i en rad 

	for(int i = 0; i < fileText.size(); i++) { 

	    parts = fileText.get(i).split(";");

	    String name = parts[0]; 
	    String author = parts[1];
	    int year = Integer.parseInt(parts[2]);
	    int weight = Integer.parseInt(parts[3]); 
	    
	    Books b = new Books(name, author, year, weight, courses.get(i));

	    this.books.add(b);
	} 
    } 

    public void readInputStudents() throws IOException { 
	List<String> fileText = Files.readAllLines(Paths.get("Student.txt"), Charset.defaultCharset()); //varje rad i filen blir ett element i listan fileText

	String[] parts; //en array som ska hålla orden i en rad 

	for(int i = 0; i < fileText.size(); i++) { 

	    parts = fileText.get(i).split(";");

	    String name = parts[0]; 
	    Student s;
	    if(i != 0){
		s = new Student(name, books.get(i-1), courses.get(i));
	    } 
	    else { //i = 0
		s = new Student(name, books.get(12), courses.get(i));
	    }
	    this.students.add(s);
	} 
    }

    public void readInputFloor() throws IOException{ 

	//Randomized int list used for students and teachers
	List<Integer> list = new ArrayList<>();

	for(int j = 0; j < 13; j++){ 
	    list.add(j); 
	} 
	Collections.shuffle(list);

	//randomizing keys
	List<String> room = Files.readAllLines(Paths.get("room.txt"), Charset.defaultCharset()); 
	List<String> hallway = Files.readAllLines(Paths.get("hallway.txt"), Charset.defaultCharset()); 
	int amountOfRoomsAndHallways = room.size() + hallway.size();

	ArrayList<ArrayList<Item>> inceptionKeyList = new ArrayList<ArrayList<Item>>();
	Random random = new Random();
	int totalAmountOfRandomizedKeys = 0;
	int maxAmountOfKeysPerRoom = 4;

	for(int h = 0; h < amountOfRoomsAndHallways; h++){ 
	    int randomInt;    
	    randomInt = random.nextInt(maxAmountOfKeysPerRoom); //exlusive maxAmountOfKeysPerRoomMinusOne 
	    
	    ArrayList<Item> keys2 = new ArrayList<Item>();
	    for(int y = 0; y < (randomInt); y++){ //hej aliaseringsproblem
		keys2.add(this.keys.get(y));
	    } 
	    totalAmountOfRandomizedKeys += randomInt; 
	    inceptionKeyList.add(keys2); 
	}
	//Create rooms without references
	List<String> fileText1 = Files.readAllLines(Paths.get("room.txt"), Charset.defaultCharset()); 

	String[] parts;  

	for(int i = 0; i < fileText1.size(); i++) { 

	    parts = fileText1.get(i).split(";");

	    String name = parts[0]; 

	    Room r;

	    if(i == 13) { //hej fulkod
		r = new Room(name, null, null,inceptionKeyList.get(i));
	    } 
	    else{ 
		r = new Room(name, teachers.get(list.get(i)), students.get(list.get(i)), inceptionKeyList.get(i));
	    }
	    
	    this.rooms.add(r);  
	} 
	List<String> fileText2 = Files.readAllLines(Paths.get("hallway.txt"), Charset.defaultCharset()); 
	
	for(int g = 0; g < fileText2.size(); g++){ 

	    String[] hallwayparts = fileText2.get(g).split(";");
	    
	    String name = hallwayparts[0];
	    Room north;
	    Room south;
	    Room east;
	    Room west;
	    if(hallwayparts[1].equals("X")){ 
		north = null; 
	    } 
	    else{
		north = findRoomByName(hallwayparts[1]);
	    } 

	    if(hallwayparts[2].equals("X")){ 
		south = null; 
	    }
	    else{ 
		south = findRoomByName(hallwayparts[2]);
	    } 
	    
	    if(hallwayparts[3].equals("X")){ 
		east = null; 
	    } 
	    else{ 
		east = findRoomByName(hallwayparts[3]);
	    } 
	    
	    if(hallwayparts[4].equals("X")){
		west = null;
	    } 
	    else{
		west = findRoomByName(hallwayparts[4]); 
	    }
	    boolean doorNorth = false; 
	    boolean doorSouth = false;
	    boolean doorEast = false; 
	    boolean doorWest = false; 
	    boolean[] doors = {doorNorth, doorSouth, doorEast, doorWest};
	    for(int y = 0; y < doors.length; y++) { 
		if(hallwayparts[y+5].equals("True")){ 
		    doors[y] = true; 
		} 
	    } 
	    Room h = new Room(name,north,south,east,west,doors[0],doors[1],doors[2],doors[3],null,null,inceptionKeyList.get(fileText1.size()+g)); 
	    hallways.add(h); 
	}
	//setting room to hallway refernces
	//gå igenom hallwaylistan
	for(int f = 0; f < this.hallways.size(); f++){ 
	    if(this.hallways.get(f).getRoomNorth() != null){ 
		Room r = this.hallways.get(f).getRoomNorth(); 
		r.setRoomSouth(this.hallways.get(f)); 
	    } 
	    if(this.hallways.get(f).getRoomSouth() != null){ 
		Room r = this.hallways.get(f).getRoomSouth(); 
		r.setRoomNorth(this.hallways.get(f)); 
	    }
	    if(this.hallways.get(f).getRoomEast() != null){ 
		Room r = this.hallways.get(f).getRoomEast(); 
		r.setRoomWest(this.hallways.get(f)); 
	    } 
	    if(this.hallways.get(f).getRoomWest() != null){ 
		Room r = this.hallways.get(f).getRoomWest(); 
		r.setRoomEast(this.hallways.get(f)); 
	    }
	}

	//setting hallway to hallway references 
	this.hallways.get(0).setRoomWest(this.hallways.get(1));
	this.hallways.get(1).setRoomEast(this.hallways.get(0));
	for(int d = 1; d < hallways.size(); d++){ 
	    if(d== 1){ 
		this.hallways.get(1).setRoomSouth(this.hallways.get(2));
	    } 
	    if(d == (hallways.size()-1)){ 
		this.hallways.get(d).setRoomNorth(this.hallways.get(d-1)); 
	    }
	    else{
		this.hallways.get(d).setRoomSouth(this.hallways.get(d+1));
		this.hallways.get(d+1).setRoomNorth(this.hallways.get(d));
	    }  
	} 
	this.hallways.get(4).setRoomEast(this.hallways.get(5));
	this.hallways.get(5).setRoomWest(this.hallways.get(4));
	this.hallways.get(4).setRoomSouth(null); 
	this.hallways.get(5).setRoomNorth(null);
	    
	this.floor  = new Floor(this.hallways.get(3));	
    }

    public Room findRoomByName(String name){ 
	Room r = null;
	for(int i = 0; i < rooms.size(); i++){ 
	    if(name.equals(rooms.get(i).getName())){ 
		r = rooms.get(i); 
	    } 
	} 
	return r; 
    }
    public void createCourses(){ 
	try{ 
	    readInputCourses(); 
	} 
	catch (IOException e){ //exception som kastas om ngt går fel i Files
	    System.out.println("OH NOES!!!: " + e.getMessage());
	    e.printStackTrace(); 
	} 
    }  

    public void createBooks(){ 
	try{ 
	    readInputBooks(); 
	} 
	catch (IOException e){ //exception som kastas om ngt går fel i Files
	    System.out.println("OH NOES!!!!: " + e.getMessage());
	    e.printStackTrace(); 
	} 
    } 

    public void createTeachers(){ 
	for(int i = 0; i < courses.size(); i++){ 
	    Teacher t = new Teacher(courses.get(i)); 
	    teachers.add(t); 
	}
    } 

    public void createKeys(){ 
	for(int i = 0; i < 21; i++){ 
	    Key k = new Key("Hola"); 
	    keys.add(k); 
	} 
    } 

    public void createStudents(){ 
	try{ 
	    readInputStudents();
	}
	catch (IOException e){ 
	    System.out.println("Det blev fel nu visst, det var ju jobbigt: " + e.getMessage());
	    e.printStackTrace(); 
	}  
    }

    public void createFloor(){ 
	try{ 
	    readInputFloor(); 
	} 
	catch (IOException e){ 
	    System.out.println("Det blev fel nu visst: " + e.getMessage());
	    e.printStackTrace(); 
	} 
    } 

    public void createAvatar(){ 
	//slumpa 10HP kurser 
	ArrayList<Course> courses10HP = new ArrayList<Course>(); 
	for(int i = 0; i < this.courses.size(); i++){ 
	    if(courses.get(i).getHP() == 10){ 
		courses10HP.add(courses.get(i));
	    } 
	} 
	List<Integer> randomnr = new ArrayList<>();
	for(int j = 0; j < 6; j++){ 
	    randomnr.add(j); 
	} 
	Collections.shuffle(randomnr);
	//skapa avatar
	ArrayList<Course> c = new ArrayList<Course>();
	for(int y = 0; y < 6; y++){ 
	    c.add(courses10HP.get(randomnr.get(y)));
	}
	this.avatar = new Avatar(c);
    }

    public ArrayList<Teacher> getTeachers(){ 
	return this.teachers; 
    }

    public ArrayList<Books> getBooks(){ 
	return this.books; 
    } 

    public ArrayList<Item> getKeys(){ 
	return this.keys; 
    } 

    public ArrayList<Course> getCourses(){ 
	return this.courses; 
    } 

    public ArrayList<Student> getStudents(){ 
	return this.students; 
    }

    public Floor getFloor(){ 
	return this.floor; 
    } 

    public ArrayList<Room> getRooms(){ 
	return this.rooms; 
    } 

    public ArrayList<Room> getHallways(){ 
	return this.hallways; 
    } 
    
    public Avatar getAvatar(){ 
	return this.avatar; 
    }

    public Room getFirst(){ 
	return this.floor.getFirst();
    }

    public static void main(String[] args){ 
	World world = new World();
	System.out.println(world.getCourses());
	System.out.println(world.getTeachers());
	System.out.println(world.getBooks());
	System.out.println(world.getKeys());
	System.out.println(world.getStudents());
	System.out.println(world.getFloor());
	System.out.println(world.getRooms()); 
	System.out.println(world.getHallways());
	System.out.println(world.getFirst());
	System.out.println(world.getAvatar());
    }
}

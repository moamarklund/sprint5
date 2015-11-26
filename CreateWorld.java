import java.util.*; 

public class CreateWorld{ 

    //Attribut
    //??? 

    //Konstruktor 
    public CreateWorld(){ 
	//skapa kurser
	ArrayList<String> a1 = create("Vem är snyggaste labbassen?","Henrik","Han med tofsboll", "Mikael"); 
	ArrayList<String> a2 = create("Vad babblar Elias och Tobias om EGENTLIGEN?","heybaberiba", "bananer i pyjamas", "bolibompa"); 
	ArrayList<String> a3 = create("Vad fan är en statisk variabel?", "En variabel som tillhör klassen och inte objekten","Ingen jävla aning", "Fråga någon i foobar"); 
	Course ioopm = new Course("IOOPM",a1,a2,a3,20); 
	
	ArrayList<String> b1 = create("Vem har fått omtenta på omtentan i denna kurs?","Malin","Elsa","Moa"); 
	ArrayList<String> b2 = create("Hur många föreläsningar gick Malin på?","2 st","1 st","alla"); 
	ArrayList<String> b3 = create("Vad heter datorarkitektur på grekiska?","Αρχιτεκτονική Υπολογιστών","υπολογιστή","τι κάνω");
	Course darken = new Course("Datorarkitektur",b1,b2,b3); 
	
        ArrayList<String> c1 = create("Vad hjälper mest när du är bakis?","resorb","mat","kaffe"); 
	ArrayList<String> c2 = create("Vad är mest linjärt?", "en linjal","x + 2y","y-axeln i sig"); 
	ArrayList<String> c3 = create("Vad vill du helst inte berätta dagen efter?", "Att du fyllekäka upp din kompis rabarberpaj","Hur du trilla ner i trapphuset och landade i pöl","Var du vakna upp dagen efter"); 
	Course linjarBakisAlgebra = new Course("Linjär bakisalgebra",c1,c2,c3); 

	ArrayList<String> d1 = create("Vad hette Ada Lovelace egentligen?","Augusta Ada King", "Ada Lovelace", "Augusta Ada Byron"); 
	ArrayList<String> d2 = create("Vem uppfann not,and,or,true,false mm?", "George Boole", "Alan Turing", "Charles Peirce");
	ArrayList<String> d3 = create("Vad är Alan Turing mest känd för?","The turning machine", "Creating algorithms for decryption during the second world war","Something smart"); 
	Course kurs = new Course("Programmeringshistoria",d1,d2,d3);

	ArrayList<String> e1 = create("Vilken julmust är godast?","Zeunerts","Nygårda","Apotekarnes"); 
	ArrayList<String> e2 = create("Vilken julmust gillar tomten mest?","Zeunerts","Rom och julmust","Nygårda"); 
	ArrayList<String> e3 = create("Vilken julmust finns på luthagens för 7.90 kr?","Nygårdas lagrad julmust med romfat","Zeunerts","Vanliga nygårda"); 
	Course julmust = new Course("Julmustsåsikter",e1,e2,e3); 

	ArrayList<String> f1 = create("Vad är motsvarigheten till wikipedia?","Encyklopedia galactica", "Encyklopedia intergalactica","Universipedia"); 
	ArrayList<String> f2 = create("Hur känns effekten av den all galaktiska gurgelbrännaren?","Som att få hjärnan krossad av en guldtacka svept i citronskivor", "Som att tungan fastnar på en kall lyktstolpe när det är fullmåne","Som att få tungan krossad av en silvertacka en ljus septembermorgon"); 
	ArrayList<String> f3 = create("Vad drivs deras rymdskepp av?","Den oändliga osannolikhetsdriften","Den oändliga bakfulldriften","Den omättliga dinosaurien Robert"); 
	Course liftaren = new Course("Liftarens guide till galaxen",f1,f2,f3);

	//skapa avatar
	//skapa nycklar
	//skapa böcker 
	//skapa studenter 
	//skapa lärare 
	//skapa våningsplan o rum
}
    //Metoder 

    public ArrayList<String> create(String question, String rightAnswer, String falseAnswer1, String falseAnswer2){ 
	ArrayList<String> list = new ArrayList<String>(); 
	list.add(0, question); 
	list.add(1, rightAnswer); 
	list.add(2, falseAnswer1); 
	list.add(3, falseAnswer2);
	return list;
    }

    public int generateRandomNumber1to3(){
	Random random = new Random(); 
        int randomNumber =  random.nextInt(3);//the 3 is exclusive but inclusive 0
	return randomNumber + 1;
    } 

}

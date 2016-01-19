public class Key extends Item {

    private boolean used;

    public Key(String name, int weight, boolean used){ 
	super(name, weight); 
	this.used = used; 
    }

    public Key(String name){
        this(name,1,false); 
    } 

    public void setKey(boolean set){
	used = set; 
    } 

    /*   public Key clone() { 
	String name = super.getName().clone(); 
	int weight = this.weight.clone(); 
	boolean u = this.used.clone(); 
	Key k = new Key(name,weight,u);
	return k; 
	}*/
}

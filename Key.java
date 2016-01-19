/**
 * Represents a key
 * @param used A boolean representing if the key is used or not
 **/
public class Key extends Item {

    private boolean used;

    /**
     * Creates a key
     * @param name The name of the key
     * @param weight The weight of the key
     * @param used A boolean representing if the key is used or not
     **/
    public Key(String name, int weight, boolean used){ 
	super(name, weight); 
	this.used = used; 
    }
    /**
     * Creates a key with fixed weight and used boolean
     * @param name The name of the key
     **/
    public Key(String name){
        this(name,1,false); 
    } 

    /**
     * Sets the used boolean of a key
     * @param set The boolean to set to the key (false for unused and true for used)
     **/
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

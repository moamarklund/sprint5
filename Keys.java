public class Keys extends Objects {

    private boolean used;

    public Keys(String name){
	super(name,1);
	this.used = false; 
    } 

    public void setKey(boolean set){
	used = set; 
    }
}

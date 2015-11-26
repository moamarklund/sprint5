d    public class Keys extends Objects {
	private boolean used;

	public Keys(String name, int weight){
	    super(name, 1);
	    this.used = false;
	   
	}

	public void unlock(){
	    //Choose door to unlock
	    used = true; 
	}
    }

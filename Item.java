/**
 * Represents an item 
 * @param weight The weight of the item 
 * @param name The name of the item 
 **/
public class Item{

    protected int weight;
    protected String name;

    /**
     * Creates an item 
     * @param name The name of the item      
     * @param weight The weight of the item 
     **/
    public Item(String name, int weight){
	this.weight = weight;
	this.name = name;
    }
    /**
     * Checks the weight of the item
     * @return The weight of the item 
     **/
    public int getWeight(){
	return this.weight; 
    }
    /**
     * Checks the name of the item 
     * @return The name of the item
     **/
    public String getName(){
	return this.name;
    } 
   

}

    
  

	
    


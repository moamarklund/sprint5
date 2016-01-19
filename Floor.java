import java.util.*;
/**
 * Represents the second floor at Pollax
 * @param first The first room 
 **/
public class Floor{
    private Room first; 

    /**
     * Creates a floor
     * @param room The room to start from
     **/
    public Floor(Room room){
	this.first = room;
    }
    /**
     * Checks the first room in the floor
     * @return The first room in the floor
     **/
    public Room getFirst(){ 
	return this.first; 
    }
}

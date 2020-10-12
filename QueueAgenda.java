package com.maxim;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAgenda extends Agenda {
    LinkedList<Location> list;
    int numItems = 0;

    /**
     *Creating a QueueAgenda class
     *Implemented with standard Java LinkedList structure
     */
    public QueueAgenda() {
        list = new LinkedList<Location>();
	    int numItems = list.size();
	
    }
    
    @Override
    public void addLocation(Location loc) {
	    list.add(numItems, loc);
	    numItems++;
    }
    
    @Override
    public Location getLocation() {
	    if(numItems <= 0) {
		    throw new IndexOutOfBoundsException();
	    }

	    else {
		    Location loc = list.remove();
		    numItems--;
		    return loc;
	    }
    }
    
    @Override 
    public boolean isEmpty() {
        return numItems == 0;
    }
    
    @Override
    public void clear()
    {
	list.clear();
    }
}
	

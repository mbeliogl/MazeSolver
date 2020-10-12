
package com.maxim;
import java.util.Stack;


/**
 * Creating a StackAgenda class
 * Implemented with standard Java Stack structure
 */
public class StackAgenda extends Agenda {

    public Stack<Location> stack;
    public StackAgenda()
    {
	stack = new Stack<Location>();
    }

    @Override
    public void addLocation(Location loc) { stack.push(loc); }
    
    @Override
    public Location getLocation() { return stack.pop(); }

    @Override
    public boolean isEmpty()
    {
	return stack.empty();
    }

    @Override
    public void clear(){
	    while(! stack.empty()) { stack.pop(); }   //pop all items from the stack
    }
}

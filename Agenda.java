package com.maxim;

/**
 * Declaring abstract class Agenda
 * addLocation(loc) : add location to Agenda
 * getLocation() : remove and return location
 * isEmpty() : check if Agenda is empty
 * clear() : remove all items from Agenda
 */
public abstract class Agenda
{
    public abstract void addLocation(Location loc);
    public abstract Location getLocation();
    public abstract boolean isEmpty();
    public abstract void clear();
}

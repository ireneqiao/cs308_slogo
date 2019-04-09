package operations;

import general.DisplayModel;
import general.SystemStorage;

/**
 * @author Irene Qiao isq
 * Purpose: SystemStorageOperation is a TurtleOperation that is an Operation and has instance variables for the SystemStorage
 * and DisplayModel, as well as setter and getter methods for these variables.
 * Assumptions: that where the SystemStorageOperation is instantiated, the setter methods will be called so that the getter methods
 * for the variables do not result in null pointer exceptions.
 * Dependencies: SystemStorage, DisplayModel classes
 * How to use: SystemStorageOperation is a superclass, so can only instantiate concrete classes that inherit from the superclass.
 * Then, must use setter methods so that the instance variables are not null.
 */
abstract public class SystemStorageOperation extends TurtleOperation {
    private final int NUM_ARGS = 0;
    private SystemStorage myStorage;
    private DisplayModel myDisplay;

    /**
     * Constructor for SystemStorageOperation. Since all of these Operations require 0 arguments, the number of args can be
     * set in the constructor.
     */
    public SystemStorageOperation(){
        super();
        setNumArgs(NUM_ARGS);
    }

    /**
     * Returns a double value particular to the type of Operation, overriden by subclass implementations.
     * @return double
     */
    @Override
    abstract public double evaluate();

    protected SystemStorage getSystemStorage(){
        return myStorage;
    }

    protected DisplayModel getMyDisplay(){
        return myDisplay;
    }

    /**
     * Sets myStorage and myDisplay so that the instance variables are not null.
     * @param storage SystemStorage used
     */
    public void setSystemStorage(SystemStorage storage){
        myStorage = storage;
        myDisplay = myStorage.getDisplay();
    }
}

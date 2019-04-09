package operations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Irene Qiao isq
 * Purpose: An Operation has an array of arguments, a number storing the number of arguments, and can have unlimited arguments
 * (for parsing groups of commands/using parentheses). All operations implement evaluate(), which returns a double value.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Operation is an abstract superclass for many Operations, all of which must implement the abstract method
 * evaluate(). Operation was created so that evaluate() could be called on all Operations, regardless of whether they are Commands.
 * This way, when simplifying the arguments of a Command or Operation, we can use the return value from evaluate() to determine if the
 * value is a valid argument without having to actually execute the nested Command if it is invalid.
 */
abstract public class Operation {
    private int myNumArgs;
    private double[] myArgs;
    private boolean hasUnlimitedArgs = false;

    /**
     * Default constructor for abstract superclass Operation
     */
    public Operation() {
    }

    protected void setNumArgs(int num){
        myNumArgs = num;
    }

    /**
     * Returns a double value as a result of calling the particular Operation
     * @return a double value, particular to the type of Operation
     */
    abstract public double evaluate();

    /**
     * Returns myNumArgs, the number of arguments required for the Operation
     * @return myNumArgs
     */
    public int getNumArgs() {
        return myNumArgs;
    }

    /**
     * Sets myArgs as a double array of arguments, passed in after parsing
     * @param args double array of arguments for the Operation
     */
    public void setArgs(double[] args){
        myArgs = args;
    }

    /**
     * Returns boolean hasUnlimitedArgs, , which is true if the number of args is unlimited in grouping cases, false if otherwise
     * @return boolean hasUnlimitedArgs
    **/
    public boolean hasUnlimitedArgs(){
        return hasUnlimitedArgs;
    }

    protected void setUnlimitedArgs(){
        hasUnlimitedArgs = true;
    }
    
    protected double getArgIndex(int index){
        return myArgs[index];
    }

}


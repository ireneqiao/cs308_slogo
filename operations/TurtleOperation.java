package operations;

import general.Animal;

/**
 * @author Irene Qiao isq
 * Purpose:TurtleOperation is an Operation and has an instance variable for the Animal on which it acts,
 * well as a setter and getter method to set and get the particular Animal.
 * Assumptions: that where the TurtleOperation is instantiated, the setter methods will be called so that the getter methods
 * for the variables do not result in null pointer exceptions.
 * Dependencies: Animal
 * How to use: TurtleOperation is an abstract superclass, so can only instantiate concrete classes that inherit from the superclass.
 * Then, must use setter methods so that the instance variables are not null.
 */
abstract public class TurtleOperation extends Operation {
    private Animal myTurtle;

    /**
     * Constructor for TurtleOperation, default
     */
    public TurtleOperation(){
        super();
    }

    /**
     * Sets specific Animal to be acted upon/queried by the TurtleOperation
     * @param turtle Animal to be acted upon/queried
     */
    public void setAnimal(Animal turtle){
        myTurtle = turtle;
    }

    protected Animal getTurtle(){
        return myTurtle;
    }

    protected double calcDistance(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2, 2));
    }

    /**
     * Implementation varies, returns a double value
     * @return double value result of evaluation, implementation depends on specific Operation
     */
    @Override
    abstract public double evaluate();

}



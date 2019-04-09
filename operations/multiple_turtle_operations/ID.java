package operations.multiple_turtle_operations;

import operations.TurtleOperation;

/**
 * @author Irene Qiao
 * Purpose: ID has evaluate() method that returns the ID of the active turtle.
 * Assumptions: OperationBuilder needs to set the correct turtle for ID to return the correct value.
 * Dependencies: Animal class
 * How to use: Instantiate ID, set active turtle, and call evaluate() to return the ID of the active turtle.
 */
public class ID extends TurtleOperation {
    private int ID_NUM_ARGS = 0;

    /**
     * Default constructor
     */
    public ID() {
        super();
        setNumArgs(ID_NUM_ARGS);
    }

    /**
     * Returns double ID value of active animal
     * @return double ID value of active animal
     */
    @Override
    public double evaluate() {
        return Double.parseDouble(getTurtle().getAnimalID());
    }

}

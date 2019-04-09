package operations.multiple_turtle_operations;

import operations.SystemStorageOperation;

/**
 * @author Irene Qiao
 * Purpose: NumTurtles has evaluate() method that returns the number of Animals instantiated.
 * Assumptions: OperationBuilder needs to set the correct turtle for ID to return the correct value.
 * Dependencies: SystemStorage class
 * How to use: Instantiate NumTurtles, set SystemStorage, and call evaluate() to return the number of instantiated turtles.
 */
public class NumTurtles extends SystemStorageOperation {
    private final int NUM_TURTLES_NUM_ARGS = 0;

    /**
     * Default constructor
     */
    public NumTurtles() {
        super();
        setNumArgs(NUM_TURTLES_NUM_ARGS);
    }

    /**
     * Returns double number of Animals.
     * @return double number of Animals.
     */
    @Override
    public double evaluate() {
        return getSystemStorage().getAnimals().keySet().size();
    }

}

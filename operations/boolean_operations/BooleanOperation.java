package operations.boolean_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: BooleanOperation is an Operation that can return 0 or 1 based on a calculated boolean value. This abstract class contains
 * information about the number of arguments that all BooleanOperations contain and the double value that represents a true or false value.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Extend from this superclass to create concrete subclasses AndOperation or EqualTo.
 */
abstract public class BooleanOperation extends Operation {
    private final int BOOLEAN_NUM_ARGS = 2;
    private final double TRUE_VAL = 1;
    private final double FALSE_VAL = 0;

    /**
     * Default constructor
     */
    public BooleanOperation(){
        super();
        setNumArgs(BOOLEAN_NUM_ARGS);
    }

    protected double getReturnValue(boolean ret){
        if (ret){
            return TRUE_VAL;
        }
        else {
            return FALSE_VAL;
        }
    }

    /**
     * Returns a double 0 or 1 based on whether calculated boolean value is true or false.
     * @return double 0 or 1 based on whether calculated boolean value is true or false.
     */
    @Override
    abstract public double evaluate();
}

package operations.trigonometric_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: ArcTanOperation has evaluate() method that returns the arctan of the input.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate ArcTanOperation, set argument, and call evaluate() to return the arctan of the argument.
 */
public class ArcTanOperation extends Operation {
    private final int ARCTAN_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public ArcTanOperation(){
        super();
        setNumArgs(ARCTAN_NUM_ARGS);
    }

    /**
     * Returns arctan of argument
     * @return double arctan of argument
     */
    @Override
    public double evaluate() {
        return Math.atan(getArgIndex(0));
    }
}

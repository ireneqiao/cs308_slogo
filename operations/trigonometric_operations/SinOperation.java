package operations.trigonometric_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: SinOperation has evaluate() method that returns the sine of the input.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate SinOperation, set argument, and call evaluate() to return the sine of the argument.
 */
public class SinOperation extends Operation {
    private final int SIN_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public SinOperation(){
        super();
        setNumArgs(SIN_NUM_ARGS);
    }

    /**
     * Returns double sine of argument
     * @return double sine of argument
     */
    @Override
    public double evaluate() {
        return Math.sin(getArgIndex(0));
    }
}

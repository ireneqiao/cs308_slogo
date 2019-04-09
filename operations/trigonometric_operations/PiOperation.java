package operations.trigonometric_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: PiOperation has evaluate() method that value of pi.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate PiOperation and call evaluate() to return the value of pi.
 */
public class PiOperation extends Operation {
    private final int PI_NUM_ARGS = 0;

    /**
     * Default constructor
     */
    public PiOperation(){
        super();
        setNumArgs(PI_NUM_ARGS);
    }

    /**
     * Returns double constant pi
     * @return double constant pi
     */
    @Override
    public double evaluate() {
        return Math.PI;
    }
}

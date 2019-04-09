package operations.trigonometric_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: TanOperation has evaluate() method that returns the tangent of the input.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate TanOperation, set argument, and call evaluate() to return the tangent of the argument.
 */
public class TanOperation extends Operation {
    private final int TAN_NUM_ARGS = 1;

    /**
     * Default constructor.
     */
    public TanOperation(){
        super();
        setNumArgs(TAN_NUM_ARGS);
    }

    /**
     * Returns double tangent of argument
     * @return double tangent of argument
     */
    @Override
    public double evaluate() {
        return Math.tan(getArgIndex(0));
    }

}

package operations.trigonometric_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: CosOperation has evaluate() method that returns the cosine of the input.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate CosOperation, set argument, and call evaluate() to return the cosine of the argument.
 */
public class CosOperation extends Operation {
    private final int COS_NUM_ARGS = 1;

    /**
     * Default constrcutor
     */
    public CosOperation(){
        super();
        setNumArgs(COS_NUM_ARGS);
    }

    /**
     * Returns cosine of argument
     * @return double cosine of argument
     */
    @Override
    public double evaluate() {
        return Math.cos(getArgIndex(0));
    }
}

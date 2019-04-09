package operations.math_operations;

import operations.Operation;


/**
 * @author Irene Qiao
 * Purpose: SumOperation has evaluate() method that returns the sum of the arguments.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate SumOperation, set arguments, and call evaluate() to return the sum of the arguments.
 */
public class SumOperation extends Operation {
    private final int SUM_NUM_ARGS = 2;

    /**
     * Default constructor
     */
    public SumOperation() {
        super();
        setNumArgs(SUM_NUM_ARGS);
        setUnlimitedArgs();
    }

    /**
     * Returns the double value of the sum of the arguments
     * @return double value of the sum of the arguments
     */
    @Override
    public double evaluate() {
        double sum = getArgIndex(0) + getArgIndex(1);
        return sum;
    }

}

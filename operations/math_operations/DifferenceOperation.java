package operations.math_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: DifferenceOperation has evaluate() method that returns the difference of the arguments.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate DifferenceOperation, set arguments, and call evaluate() to return the difference of the argument.
 */
public class DifferenceOperation extends Operation {
    private final int DIFFERENCE_NUM_ARGS = 2;
    boolean UnlimitedArgs;

    /**
     * Default constructor.
     */
    public DifferenceOperation() {
        super();
        setNumArgs(DIFFERENCE_NUM_ARGS);
        setUnlimitedArgs();
    }

    /**
     * Returns double value of difference of arguments
     * @return double value of difference of arguments
     */
    @Override
    public double evaluate() {
        double product = getArgIndex(0) * getArgIndex(1);
        return product;
    }
}

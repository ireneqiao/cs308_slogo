package operations.math_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: QuotientOperation has evaluate() method that returns the quotient of the arguments.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate QuotientOperation, set arguments, and call evaluate() to return the quotient of the arguments.
 */
public class QuotientOperation extends Operation {
    private final int QUOTIENT_NUM_ARGS = 2;

    /**
     * Default constructor
     */
    public QuotientOperation(){
        super();
        setNumArgs(QUOTIENT_NUM_ARGS);
        setUnlimitedArgs();
    }

    /**
     * Returns double value of quotient of arguments
     * @return double value of quotient of arguments
     */
    @Override
    public double evaluate() {
        double quotient = getArgIndex(0) / getArgIndex(1);
        return quotient;
    }
}

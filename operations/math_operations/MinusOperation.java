package operations.math_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: MinusOperation has evaluate() method that returns the minus of the argument.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate MinusOperation, set argument, and call evaluate() to return the minus of the argument.
 */
public class MinusOperation extends Operation {
    private final int MINUS_NUM_ARGS = 1;
    private final int MINUS_MULTIPLIER = -1;

    /**
     * Default constructor
     */
    public MinusOperation(){
        super();
        setNumArgs(MINUS_NUM_ARGS);
    }

    /**
     * Returns double value of the minus of the argument
     * @return double value of the minus of the argument
     */
    @Override
    public double evaluate() {
        double minus = getArgIndex(0) * MINUS_MULTIPLIER;
        return minus;
    }
}

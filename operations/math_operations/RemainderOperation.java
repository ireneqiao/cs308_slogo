package operations.math_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: RemainderOperation has evaluate() method that returns the remainder of the first argument divided by the second.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate Remainder, set arguments, and call evaluate() to return the remainder of the first argument
 * divided by the second.
 */
public class RemainderOperation extends Operation {
    private final int REMAINDER_NUM_ARGS = 2;

    /**
     * Default constructor
     */
    public RemainderOperation(){
        super();
        setNumArgs(REMAINDER_NUM_ARGS);
        setUnlimitedArgs();
    }

    /**
     * Returns the double value of the remainder of the first argument divided by the second.
     * @return double value of the remainder of the first argument divided by the second.
     */
    @Override
    public double evaluate() {
        double remainder = getArgIndex(0) % getArgIndex(1);
        return remainder;
    }
}

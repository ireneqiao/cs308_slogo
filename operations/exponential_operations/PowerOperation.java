package operations.exponential_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: PowerOperation has evaluate() method that returns the value of the first argument to the power of the
 * second argument.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate PowerOperation, set arguments, and call evaluate() to return the value of the first argument
 * to the power of the second argument.
 */
public class PowerOperation extends Operation {
    private final int POWER_NUM_ARGS = 2;

    /**
     * Default constructor
     */
    public PowerOperation(){
        super();
        setNumArgs(POWER_NUM_ARGS);
    }

    /**
     * Returns the value of the first argument to the power of the second argument.
     * @return double value of the first argument to the power of the second argument.
     */
    @Override
    public double evaluate() {
        return Math.pow(getArgIndex(0), getArgIndex(1));
    }
}

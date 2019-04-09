package operations.exponential_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: LogOperation has evaluate() method that returns the log of the argument.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate LogOperation, set argument, and call evaluate() to return the log of the argument.
 */
public class LogOperation extends Operation {
    private final int LOG_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public LogOperation(){
        super();
        setNumArgs(LOG_NUM_ARGS);
    }

    /**
     * Return double value of log of argument
     * @return double value of log of argument
     */
    @Override
    public double evaluate() {
        return Math.log(getArgIndex(0));

    }
}

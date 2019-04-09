package operations.boolean_operations;

/**
 * @author Irene Qiao
 * Purpose: NotOperation has evaluate() method that returns true if the argument is false.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate NotOperation, set argument, and call evaluate() to return 0 or 1 based on calculated boolean value.
 */
public class NotOperation extends BooleanOperation {
    private final int NOT_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public NotOperation(){
        super();
        setNumArgs(NOT_NUM_ARGS);
    }

    /**
     * Return double value 1 if the argument is false, 0 if otherwise.
     * @return double value 1 if the argument is false, 0 if otherwise.
     */
    @Override
    public double evaluate() {
        boolean ret = getArgIndex(0) == 0;
        return getReturnValue(ret);
    }
}

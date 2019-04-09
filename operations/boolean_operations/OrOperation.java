package operations.boolean_operations;

/**
 * @author Irene Qiao
 * Purpose: OrOperation has evaluate() method that returns true if at least one argument is true, false if otherwise.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate OrOperation, set arguments, and call evaluate() to return 0 or 1 based on calculated boolean value.
 */
public class OrOperation extends BooleanOperation {

    /**
     * Default constructor
     */
    public OrOperation(){
        super();
        setUnlimitedArgs();
    }

    /**
     * Return double value 1 if at least one of the arguments is true, 0 if otherwise.
     * @return double value 1 if at least one of the arguments is true, 0 if otherwise.
     */
    @Override
    public double evaluate() {
        boolean ret = (getArgIndex(0) != 0) || (getArgIndex(1) != 0);
        return getReturnValue(ret);
    }
}

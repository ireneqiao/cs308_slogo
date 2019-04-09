package operations.boolean_operations;

/**
 * @author Irene Qiao
 * Purpose: AndOperation has evaluate() method that returns true if both arguments are true.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate AndOperation, set arguments, and call evaluate() to return 0 or 1 based on calculated boolean value.
 */
public class AndOperation extends BooleanOperation {

    /**
     * Default constructor.
     */
    public AndOperation(){
        super();
        setUnlimitedArgs();
    }

    /**
     * Returns 1 if both arguments are true, 0 if otherwise.
     * @return double 1 if both arguments are true, 0 if otherwise.
     */
    @Override
    public double evaluate() {
        boolean ret = (getArgIndex(0) != 0) && (getArgIndex(1) != 0);
        return getReturnValue(ret);
    }
}

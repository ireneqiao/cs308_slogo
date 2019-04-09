package operations.boolean_operations;

/**
 * @author Irene Qiao
 * Purpose: EqualTo has evaluate() method that returns true if both arguments are equal.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate EqualOperation, set arguments, and call evaluate() to return 0 or 1 based on calculated boolean value.
 */
public class EqualTo extends BooleanOperation {

    /**
     * Default constructor
     */
    public EqualTo(){
        super();
        setUnlimitedArgs();
    }

    /**
     * Returns double value 1 if both arguments are equal, 0 if otherwise.
     * @return double value 1 if both arguments are equal, 0 if otherwise.
     */
    @Override
    public double evaluate() {
        boolean ret = getArgIndex(0) == getArgIndex(1);
        return getReturnValue(ret);
    }
}

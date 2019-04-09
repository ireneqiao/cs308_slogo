package operations.boolean_operations;

/**
 * @author Irene Qiao
 * Purpose: NotEqualTo has evaluate() method that returns true if the first argument is not equal to the second.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate NotEqualTo, set arguments, and call evaluate() to return 0 or 1 based on calculated boolean value.
 */
public class NotEqualTo extends BooleanOperation {

    /**
     * Default constructor
     */
    public NotEqualTo(){
        super();
        setUnlimitedArgs();
    }

    /**
     * Return double value 1 if both arguments are not equal to each other, 0 if otherwise.
     * @return double value 1 if both arguments are not equal to each other, 0 if otherwise.
     */
    @Override
    public double evaluate() {
        boolean ret = getArgIndex(0) != getArgIndex(1);
        return getReturnValue(ret);
    }
}

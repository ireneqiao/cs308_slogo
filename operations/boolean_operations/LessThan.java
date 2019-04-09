package operations.boolean_operations;


/**
 * @author Irene Qiao
 * Purpose: Lessthan has evaluate() method that returns true if the first argument is less than the second.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate LessThan, set arguments, and call evaluate() to return 0 or 1 based on calculated boolean value.
 */
public class LessThan extends BooleanOperation {

    /**
     * Default constructor
     */
    public LessThan(){
        super();
        setUnlimitedArgs();
    }

    /**
     * Return double value 1 if first argument less than the second, 0 if otherwise.
     * @return double value 1 if first argument less than the second, 0 if otherwise.
     */
    @Override
    public double evaluate() {
        boolean ret = getArgIndex(0) < getArgIndex(1);
        return getReturnValue(ret);
    }
}

package operations.boolean_operations;

/**
 * @author Irene Qiao
 * Purpose: GreaterThan has evaluate() method that returns true if the first argument is greater than the second.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate GreaterThan, set arguments, and call evaluate() to return 0 or 1 based on calculated boolean value.
 */
public class GreaterThan extends BooleanOperation {

    /**
     * Default constructor
     */
    public GreaterThan(){
        super();
        setUnlimitedArgs();
    }

    /**
     * Returns double value 1 if the first argument is greater than the second argument, 0 if otherwise.
     * @return double value 1 if the first argument is greater than the second argument, 0 if otherwise.
     */
    @Override
    public double evaluate() {
        boolean ret = getArgIndex(0) > getArgIndex(1);
        if (ret){
            return 1;
        }
        else {
            return 0;
        }
    }
}

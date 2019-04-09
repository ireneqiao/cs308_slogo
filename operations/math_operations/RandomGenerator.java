package operations.math_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: RandomGenerator has evaluate() method that returns a random number that is strictly less than the argument.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate RandomGenerator, set argument, and call evaluate() to return a random number strictly less than
 * the argument.
 */
public class RandomGenerator extends Operation {
    private final int RANDOM_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public RandomGenerator (){
        super();
        setNumArgs(RANDOM_NUM_ARGS);
    }

    /**
     * Returns a double value that is a random number strictly less than the argument
     * @return double value that is a random number strictly less than the arguments
     */
    @Override
    public double evaluate() {
        return Math.random() * getArgIndex(0);
    }
}

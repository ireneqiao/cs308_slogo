package operations.math_operations;

import operations.Operation;

/**
 * @author Irene Qiao
 * Purpose: ProductOperation has evaluate() method that returns the product of the arguments.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: Instantiate ProductOperation, set arguments, and call evaluate() to return the product of the arguments.
 */
public class ProductOperation extends Operation {
    private final int PRODUCT_NUM_ARGS = 2;

    /**
     * Default constructor
     */
    public ProductOperation(){
        super();
        setNumArgs(PRODUCT_NUM_ARGS);
        setUnlimitedArgs();
    }

    /**
     * Returns double value of product of arguments
     * @return double value of product of arguments
     */
    @Override
    public double evaluate() {
        double product = getArgIndex(0) * getArgIndex(1);
        return product;
    }
}

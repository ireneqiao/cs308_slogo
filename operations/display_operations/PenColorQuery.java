package operations.display_operations;

import operations.SystemStorageOperation;

/**
 * @author Irene Qiao
 * Purpose: PenColorQuery is a SystemStorageOperation that can returns the index of the color of the pen of the Animal.
 * Assumptions: OperationBuilder must set correct SystemStorage to the PenColorQuery, SystemStorage methods must be implemented
 * correctly. DisplayModel methods must also be implemented correctly.
 * Dependencies: SystemStorage, Animal, DisplayModel
 * How to use: Instantiate PenColorQuery, assign SystemStorage, call evaluate() to return the index of the color of the
 * pen of the Animal.
 */
public class PenColorQuery extends SystemStorageOperation {
    private final int PEN_COLOR_QUERY_NUM_ARGS = 0;

    /**
     * Default constructor
     */
    public PenColorQuery(){
        super();
        setNumArgs(PEN_COLOR_QUERY_NUM_ARGS);
    }

    /**
     * Return the double value of the index of the color of the pen of the Animal
     * @return double value of the index of the color of the pen of the Animal
     */
    @Override
    public double evaluate(){
        String color = getTurtle().getColor();
        int index = getMyDisplay().getColorsList().indexOf(color);
        return (double) index;
    }
}

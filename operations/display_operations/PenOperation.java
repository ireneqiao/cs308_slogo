package operations.display_operations;

import general.Animal;
import operations.SystemStorageOperation;

/**
 * @author Irene Qiao
 * Purpose: PenOperation is a SystemStorageOperation that can return some value related to the pen, take one argument,
 * and access the Animal and DisplayModel.
 * Assumptions: OperationBuilder must set correct SystemStorage to the PenOperation, SystemStorage methods must be implemented
 * correctly. DisplayModel methods must also be implemented correctly.
 * Dependencies: SystemStorage, Animal, DisplayModel
 * How to use: Extend PenOperation to create concrete subclasses such as PenColorQuery and SetPenColor.
 */
abstract public class PenOperation extends SystemStorageOperation {
    private final int SET_PEN_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public PenOperation(){
        super();
        setNumArgs(SET_PEN_NUM_ARGS);
    }

    /**
     * Returns some value particular to the specific subclass function.
     * @return some double value particular to the specific subclass function.
     */
    @Override
    abstract public double evaluate();

}

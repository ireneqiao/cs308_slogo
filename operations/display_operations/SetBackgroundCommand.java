package operations.display_operations;

import operations.Command;
import operations.SystemStorageOperation;

/**
 * @author Irene Qiao
 * Purpose: SetBackgroundCommand is a SystemStorageOperation and Command that can set the color of the background to the color
 * at the index specified by the argument.
 * Assumptions: OperationBuilder must set correct SystemStorage to the SetBackgroundCommand, SystemStorage methods must be implemented
 * correctly. DisplayModel methods must also be implemented correctly.
 * Dependencies: SystemStorage, Animal, DisplayModel
 * How to use: Instantiate SetBackgroundCommand, assign SystemStorage, call evaluate() if it is an argument of another Operation.
 * If all arguments are valid, then execute() will be called to change the color of the background to the color
 * at the index specified by the argument.
 */
public class SetBackgroundCommand extends SystemStorageOperation implements Command {
    private final int SET_BACKGROUND_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public SetBackgroundCommand(){
        super();
        setNumArgs(SET_BACKGROUND_NUM_ARGS);
    }

    /**
     * Return index of desired background color.
     * @return double value of index of desired background color.
     */
    @Override
    public double evaluate(){
        return getArgIndex(0);
    }

    /**
     * Set background to color at the index specified in the argument.
     */
    @Override
    public void execute(){
        getSystemStorage().getDisplay().setBackgroundColor((int) getArgIndex(0));
    }
}

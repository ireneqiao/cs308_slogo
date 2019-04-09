package operations.home_operations;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao
 * Purpose: HomeOperation is a TurtleOperation and Command that can set the position of the Animal to Home (0,0). This abstract class contains
 * information about the coordinates of Home and the number of arguments that all HomeOperations contain.
 * Assumptions: OperationBuilder must set correct Animal for HomeOperation to act on, Animal methods must be implemented
 * correctly.
 * Dependencies: Animal
 * How to use: Extend from this superclass to create concrete subclasses HomeCommand or ClearScreen.
 */
abstract public class HomeOperation extends TurtleOperation implements Command {
    private final double HOME_X = 0;
    private final double HOME_Y = 0;
    private final int HOME_OPERATION_NUM_ARGS = 0;

    /**
     * Default constructor
     */
    public HomeOperation (){
        super();
        setNumArgs(HOME_OPERATION_NUM_ARGS);
    }

    protected double getHomeX(){
        return HOME_X;
    }

    protected double getHomeY(){
        return HOME_Y;
    }

    /**
     * Execute some action particular to the specific subclass of HomeOperation.
     */
    @Override
    abstract public void execute();

    /**
     * Return some double value particular to the specific subclass of HomeOperation.
     * @return some double value particular to the specific subclass of HomeOperation.
     */
    @Override
    abstract public double evaluate();

}

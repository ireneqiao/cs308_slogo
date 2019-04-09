package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: PenDown is a TurtleOperation and a Command that can execute to change the pen status of the assigned
 * Animal to down and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of penDown() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate PenDown, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class PenDown extends TurtleOperation implements Command {
    private final int PEN_DOWN_NUM_ARGS = 0;
    private final double PEN_DOWN_VAL = 1;

    /**
     * Default constructor
     */
    public PenDown(){
        super();
        setNumArgs(PEN_DOWN_NUM_ARGS);
    }

    /**
     * Sets Animal pen as down
     */
    @Override
    public void execute() {
        getTurtle().penDown();
    }

    /**
     * Returns 1
     * @return 1
     */
    @Override
    public double evaluate() {
        return PEN_DOWN_VAL;
    }
}

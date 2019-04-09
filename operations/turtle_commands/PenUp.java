package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: PenUp is a TurtleOperation and a Command that can execute to change the pen status of the assigned
 * Animal to up and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of penUp() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate PenUp, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class PenUp extends TurtleOperation implements Command {
    private final int PEN_UP_NUM_ARGS = 0;
    private final double PEN_UP_VAL = 0;

    /**
     * Default constructor
     */
    public PenUp(){
        super();
        setNumArgs(PEN_UP_NUM_ARGS);
    }

    /**
     * Sets Animal pen as up
     */
    @Override
    public void execute() {
        getTurtle().penUp();
    }

    /**
     * Returns 0
     * @return 0
     */
    @Override
    public double evaluate() {
        return PEN_UP_VAL;
    }
}

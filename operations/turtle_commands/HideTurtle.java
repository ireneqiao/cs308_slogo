package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: HideTurtle is a TurtleOperation and a Command that can execute to change the visibility of the assigned
 * Animal and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of setVisibility() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate HideTurtle, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class HideTurtle extends TurtleOperation implements Command {
    private final int HIDE_NUM_ARGS = 0;
    private final double HIDE_VAL = 0;

    /**
     * Default constructor
     */
    public HideTurtle(){
        super();
        setNumArgs(HIDE_NUM_ARGS);
    }

    /**
     * Sets visibility of Animal to false.
     */
    @Override
    public void execute() {
        getTurtle().setVisibility(false);
    }

    /**
     * Returns 0.
     * @return 0.
     */
    @Override
    public double evaluate() {
        return HIDE_VAL;
    }
}

package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: ShowTurtle is a TurtleOperation and a Command that can execute to set the visibility of the assigned
 * Animal to visible and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of setVisibility() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate ShowTurtle, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class ShowTurtle extends TurtleOperation implements Command {
    private final int SHOW_NUM_ARGS = 0;
    private final double SHOW_VAL = 1;

    /**
     * Default constructor
     */
    public ShowTurtle(){
        super();
        setNumArgs(SHOW_NUM_ARGS);
    }

    /**
     * Set Animal visibility to true.
     */
    @Override
    public void execute() {
        getTurtle().setVisibility(true);
    }

    /**
     * Return double 1
     * @return double 1
     */
    @Override
    public double evaluate() {
        return SHOW_VAL;
    }
}

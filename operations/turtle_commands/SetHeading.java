package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: SetHeading is a TurtleOperation and a Command that can execute to set the heading of the assigned
 * Animal and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of setHeading() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate SetHeading, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class SetHeading extends TurtleOperation implements Command {
    private final int HEADING_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public SetHeading(){
        super();
        setNumArgs(HEADING_NUM_ARGS);
    }

    /**
     * Sets Animal heading to desired heading in argument
     */
    @Override
    public void execute() {
        double angle = getArgIndex(0);
        getTurtle().setHeading(angle);
    }

    /**
     * Returns the double value of heading specified in argument.
     * @return double value of heading specified in argument.
     */
    @Override
    public double evaluate() {
        return getArgIndex(0);
    }
}

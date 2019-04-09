package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: SetTowards is a TurtleOperation and a Command that can execute to set the heading of the assigned
 * Animal to face the specified coordinates and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of setToward() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate SetTowards, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class SetTowards extends TurtleOperation implements Command {
    private final int TOWARDS_NUM_ARGS = 2;

    /**
     * Default constructor
     */
    public SetTowards(){
        super();
        setNumArgs(TOWARDS_NUM_ARGS);
    }

    /**
     * Sets Animal to face coordinates specified in arguments.
     */
    @Override
    public void execute() {
        getTurtle().setToward(getArgIndex(0), getArgIndex(1));
    }

    /**
     * Returns difference in heading from previous heading to new heading when facing specified coordinates.
     * @return
     */
    @Override
    public double evaluate() {
        return getTurtle().setToward(getArgIndex(0), getArgIndex(1)); //TODO: change calculation of heading change
    }
}

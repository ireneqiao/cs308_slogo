package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: LeftRotateCommand is a TurtleOperation and a Command that can execute to change the heading of the assigned
 * Animal and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of adjustHeading() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate LeftRotateCommand, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class LeftRotateCommand extends TurtleOperation implements Command {
    private final int LEFT_ROTATE_NUM_ARGS = 1;
    private final int RIGHT_HEADING_MULTIPLIER = -1;

    /**
     * Default constructor
     */
    public LeftRotateCommand(){
        super();
        setNumArgs(LEFT_ROTATE_NUM_ARGS);
    }

    /**
     * Changes heading by amount specified by argument.
     */
    @Override
    public void execute() {
        double angle = getArgIndex(0);
        getTurtle().adjustHeading(angle * RIGHT_HEADING_MULTIPLIER);
    }

    /**
     * Returns angle amount of heading adjustment.
     * @return angle amount of heading adjustment.
     */
    @Override
    public double evaluate() {
        return getArgIndex(0);
    }
}

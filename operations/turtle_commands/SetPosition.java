package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: SetPosition is a TurtleOperation and a Command that can execute to set the position of the assigned
 * Animal and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of setPosition() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate SetPosition, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class SetPosition extends TurtleOperation implements Command {
    private final int POSITION_NUM_ARGS = 2;

    /**
     * Default constructor
     */
    public SetPosition(){
        super();
        setNumArgs(POSITION_NUM_ARGS);
    }

    /**
     * Sets position of Animal to the x and y specified in arguments.
     */
    @Override
    public void execute() {
        double x = getArgIndex(0);
        double y = getArgIndex(1);
        getTurtle().setPosition(x, y);
    }

    /**
     * Returns the double value difference in old position and new position after the Animal position is set.
     * @return double difference in old position and new position after the Animal position is set.
     */
    @Override
    public double evaluate() {
        double x = getArgIndex(0);
        double y = getArgIndex(1);
        double current_x = getTurtle().getCoordinates()[0];
        double current_y = getTurtle().getCoordinates()[1];
        return calcDistance(current_x, x, current_y, y);
    }
}

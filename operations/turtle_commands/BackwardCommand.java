package operations.turtle_commands;

import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: BackwardCommand is a TurtleOperation and a Command that can execute to change the position of the assigned
 * Animal and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of changePosition() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate BackCommand, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class BackwardCommand extends TurtleOperation implements Command {
    private final int BACKWARD_NUM_ARGS = 1;
    private final int BACKWARD_MULTIPLIER = -1;

    /**
     * Default constructor.
     */
    public BackwardCommand(){
        super();
        setNumArgs(BACKWARD_NUM_ARGS);
    }

    /**
     * Changes position of Animal, amount based on argument.
     */
    @Override
    public void execute() {
        double stepSize = getArgIndex(0);
        getTurtle().changePosition(stepSize * BACKWARD_MULTIPLIER);
    }

    /**
     * Returns double step size of desired backward movement.
     * @returnd ouble step size of desired backward movement.
     */
    @Override
    public double evaluate() {
        return getArgIndex(0);
    }
}

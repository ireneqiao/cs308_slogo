package operations.turtle_commands;

import controlStructures.For;
import operations.Command;
import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: ForwardCommand is a TurtleOperation and a Command that can execute to change the position of the assigned
 * Animal and also return the appropriate value when called to evaluate.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of changePosition() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate ForwardCommand, assign desired Animal, call evaluate() if it is an argument of another Operation. If
 * all arguments are valid, then execute() will be called to change position of the assigned Animal.
 */
public class ForwardCommand extends TurtleOperation implements Command {
    private final int FORWARD_NUM_ARGS = 1;

    /**
     * Default constructor
     */
    public ForwardCommand(){
        super();
        setNumArgs(FORWARD_NUM_ARGS);
    }

    /**
     * Changes position of Animal, amount based on argument.
     */
    @Override
    public void execute() {
        double stepSize = getArgIndex(0);
        getTurtle().changePosition(stepSize);
    }

    /**
     * Returns double step size of desired forward movement.
     * @returnd ouble step size of desired forward movement.
     */
    @Override
    public double evaluate() {
        return getArgIndex(0);
    }
}

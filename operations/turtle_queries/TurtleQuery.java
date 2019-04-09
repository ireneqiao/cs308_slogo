package operations.turtle_queries;

import operations.TurtleOperation;

/**
 * @author Irene Qiao isq
 * Purpose: TurtleQuery is a TurtleOperation is an Operation that always has 0 arguments.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null.
 * Dependencies: Animal
 * How to use: TurtleQuery is abstract and is extended by other TurtleOperations such as PenQuery and HeadingQuery. TurtleQuery
 * sets number of arguments as 0 for all children.
 */
abstract public class TurtleQuery extends TurtleOperation {
    private final int QUERY_NUM_ARGS = 0;

    /**
     * Constructor for TurtleQuery. Since TurtleQuery objects will always have 0 arguments, the numArgs can be set
     * to 0 in default constructor.
     */
    public TurtleQuery () {
        super();
        setNumArgs(QUERY_NUM_ARGS);
    }

    /**
     * Implementation varies but will return a double representing some state of the Animal.
     * @return double value representing some state of the Animal.
     */
    @Override
    abstract public double evaluate();

}

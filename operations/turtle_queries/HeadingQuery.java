package operations.turtle_queries;

/**
 * @author Irene Qiao isq
 * Purpose: HeadingQuery is a TurtleQuery is an Operation that returns the current heading of the assigned Animal when
 * evaluate() is called.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of getHeading() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate HeadingQuery, set desired Animal to act upon, and call evaluate() to obtain the heading of the assigned Animal.
 */
public class HeadingQuery extends TurtleQuery {

    /**
     * Default constructor of HeadingQuery
     */
    public HeadingQuery(){
        super();
    }

    /**
     * Returns heading of the assigned Animal
     * @return double heading value of assigned Animal
     */
    @Override
    public double evaluate() {
        return getTurtle().getHeading();
    }
}

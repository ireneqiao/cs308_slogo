package operations.turtle_queries;

/**
 * @author Irene Qiao isq
 * Purpose: XCorQuery is a TurtleQuery is an Operation that returns the current x coordinate of the assigned Animal when
 * evaluate() is called.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of getCoordinates() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate XCorQuery, assign desired Animal to query, and call evaluate() to obtain double value of x coordinate
 * of the assigned animal.
 */
public class XCorQuery extends TurtleQuery {

    /**
     * Default constructor for XCorQuery.
     */
    public XCorQuery(){
        super();
    }

    /**
     * Returns double value representing the x coordinate of the Animal
     * @return double value representing the x coordinate of the Animal
     */
    @Override
    public double evaluate() {
        return getTurtle().getCoordinates()[0];
    }
}

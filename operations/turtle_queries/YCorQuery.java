package operations.turtle_queries;

/**
 * @author Irene Qiao isq
 * Purpose: YCorQuery is a TurtleQuery is an Operation that returns the current y coordinate of the assigned Animal when
 * evaluate() is called.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of getCoordinates() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate YCorQuery, assign desired Animal to query, and call evaluate() to obtain double value of y coordinate
 * of the assigned animal.
 */
public class YCorQuery extends TurtleQuery {

    /**
     * Default constructor of YCorQuery.
     */
    public YCorQuery(){
        super();
    }

    /**
     * Returns double value representing the y coordinate of the Animal
     * @return double value representing the y coordinate of the Animal
     */
    @Override
    public double evaluate() {
        return getTurtle().getCoordinates()[1];
    }
}

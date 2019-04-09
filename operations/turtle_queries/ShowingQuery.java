package operations.turtle_queries;

/**
 * @author Irene Qiao isq
 * Purpose: ShowingQuery is a TurtleQuery is an Operation that returns the current visibility of the assigned Animal when
 * evaluate() is called.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of isVisible() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate ShowingQuery, assign desired Animal to query, and call evaluate() to obtain double 0 or 1 representing visibility of assigned Animal.
 */
public class ShowingQuery extends TurtleQuery {
    private final double SHOWING_VAL = 1;
    private final double NOT_SHOWING_VAL = 0;

    /**
     * Default constructor of ShowingQuery
     */
    public ShowingQuery(){
        super();
    }

    /**
     * Returns 1 if Animal is showing, 0 if otherwise.
     * @return double 1 if Animal is showing, 0 if not.
     */
    @Override
    public double evaluate() {
        boolean ret = getTurtle().isVisible();
        if (ret){
            return SHOWING_VAL;
        }
        else {
            return NOT_SHOWING_VAL;
        }
    }
}

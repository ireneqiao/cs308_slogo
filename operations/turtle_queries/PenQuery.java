package operations.turtle_queries;

/**
 * @author Irene Qiao isq
 * Purpose: PenQuery is a TurtleQuery is an Operation that returns the current pen status of the assigned Animal when
 * evaluate() is called.
 * Assumptions: Turtle must be correctly assigned to super or else call results in null. Implementation of getPenStatus() method
 * determines accuracy of returned result.
 * Dependencies: Animal
 * How to use: Instantiate PenQuery, assign Animal to query, and call evaluate() to obtain double 0 or 1 representing pen status of assigned Animal.
 */
public class PenQuery extends TurtleQuery {
    private final double PEN_UP_VAL = 0;
    private final double PEN_DOWN_VAL = 1;

    /**
     * Default constructor of PenQuery
     */
    public PenQuery(){
        super();
    }

    /**
     * Returns 0 or 1 for pen status, 0 if up and 1 if down.
     * @return 0 if pen is up, 1 if pen is down.
     */
    @Override
    public double evaluate() {
        boolean ret = getTurtle().getPenStatus();
        if (ret){
            return PEN_DOWN_VAL;
        }
        else {
            return PEN_UP_VAL;
        }
    }
}

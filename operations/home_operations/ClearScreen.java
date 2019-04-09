package operations.home_operations;

import operations.Command;
import operations.home_operations.HomeOperation;

/**
 * @author Irene Qiao
 * Purpose: ClearScreen is a HomeOperation and Command that can set the position of the Animal to Home (0,0) and clear
 * trails.
 * Assumptions: OperationBuilder must set correct Animal for ClearScreen to act on, Animal methods must be implemented
 * correctly.
 * Dependencies: Animal
 * How to use: Instantiate ClearScreen, assign desired Animal, call evaluate() if it is an argument of another Operation.
 * If all arguments are valid, then execute() will be called to change position of the assigned Animal and clear its trails.
 */
public class ClearScreen extends HomeOperation implements Command {

    public ClearScreen(){
        super();
    }

    /**
     * Sets Animal to Home position at (0,0) and clears trails.
     */
    @Override
    public void execute() {
        getTurtle().setPosition(getHomeX(), getHomeY());
        getTurtle().clearTrail();
    }

    /**
     * Returns the distance between old position and home position.
     * @return double value of the distance between old position and home position.
     */
    @Override
    public double evaluate() {
        double current_x = getTurtle().getCoordinates()[0];
        double current_y = getTurtle().getCoordinates()[1];
        return calcDistance(current_x, getHomeX(), current_y, getHomeY());
    }
}

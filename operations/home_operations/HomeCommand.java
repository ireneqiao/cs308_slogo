package operations.home_operations;

import operations.Command;

/**
 * @author Irene Qiao
 * Purpose: HomeCommand is a HomeOperation and Command that can set the position of the Animal to Home (0,0) and clear
 * trails.
 * Assumptions: OperationBuilder must set correct Animal for HomeCommand to act on, Animal methods must be implemented
 * correctly.
 * Dependencies: Animal
 * How to use: Instantiate HomeCommand, assign desired Animal, call evaluate() if it is an argument of another Operation.
 * If all arguments are valid, then execute() will be called to change position of the assigned Animal to the home position.
 */
public class HomeCommand extends HomeOperation implements Command {

    /**
     * Default constructor
     */
    public HomeCommand(){
        super();
    }

    /**
     * Sets position of assigned Animal to home
     */
    @Override
    public void execute() {
        getTurtle().setPosition(getHomeX(), getHomeY());
    }

    /**
     * Returns distance between previous position and home position.
     * @return double value of distance between previous position and home position.
     */
    @Override
    public double evaluate() {
        double current_x = getTurtle().getCoordinates()[0];
        double current_y = getTurtle().getCoordinates()[1];
        return calcDistance(current_x, getHomeX(), current_y, getHomeY());
    }
}

package operations.display_operations;

import general.SystemStorage;
import operations.Command;

/**
 * @author Irene Qiao
 * Purpose: SetPenColor is a PenOperation and Command that can set the color of an index of the palette to
 * the value specified by r g b arguments.
 * Assumptions: OperationBuilder must set correct SystemStorage to the PenColorQuery, SystemStorage methods must be implemented
 * correctly. DisplayModel methods must also be implemented correctly.
 * Dependencies: SystemStorage, Animal, DisplayModel
 * How to use: Instantiate SetPaletteCommand, assign SystemStorage, call evaluate() if it is an argument of another Operation.
 * If all arguments are valid, then execute() will be called to set the color of an index of the palette to
 * the value specified by r g b arguments.
 */
public class SetPenColor extends PenOperation implements Command {
    public SetPenColor(){
        super();
    }

    @Override
    public double evaluate(){
        return getArgIndex(0);
    }

    @Override
    public void execute(){
        String color = getSystemStorage().getDisplay().getColor((int) getArgIndex(0));
        getTurtle().setPenColor(color);
    }
}

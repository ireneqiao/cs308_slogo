package operations.display_operations;

import general.DisplayModel;
import operations.Command;
import operations.SystemStorageOperation;

/**
 * @author Irene Qiao
 * Purpose: SetPaletteCommand is a PenOperation and Command that can set the color of an index of the palette to
 * the value specified by r g b arguments.
 * Assumptions: OperationBuilder must set correct SystemStorage to the PenColorQuery, SystemStorage methods must be implemented
 * correctly. DisplayModel methods must also be implemented correctly.
 * Dependencies: SystemStorage, Animal, DisplayModel
 * How to use: Instantiate SetPaletteCommand, assign SystemStorage, call evaluate() if it is an argument of another Operation.
 * If all arguments are valid, then execute() will be called to set the color of an index of the palette to
 * the value specified by r g b arguments.
 */
public class SetPaletteCommand extends SystemStorageOperation implements Command {
    private final int PALETTE_COMMAND_NUM_ARGS = 4;
    private final int RED_ARG_INDEX = 1;
    private final int GREEN_ARG_INDEX = 2;
    private final int BLUE_ARG_INDEX = 3;

    private DisplayModel myDisplay;

    /**
     * Default constructor
     */
    public SetPaletteCommand(){
        super();
        setNumArgs(PALETTE_COMMAND_NUM_ARGS);
    }

    /**
     * Sets the color of an index of the palette to the value specified by r g b arguments.
     */
    @Override
    public void execute(){
        int index = (int) getArgIndex(0);
        int r = (int) getArgIndex(RED_ARG_INDEX);
        int g = (int) getArgIndex(GREEN_ARG_INDEX);
        int b = (int) getArgIndex(BLUE_ARG_INDEX);
        String hex = String.format("#%02x%02x%02x", r, g, b);
        myDisplay.setColorListItem(index, hex);
    }

    /**
     * Return double value of desired index of palette to change.
     * @return double value of desired index of palette to change.
     */
    @Override
    public double evaluate(){
        return getArgIndex(0);
    }
}

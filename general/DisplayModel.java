package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Irene Qiao isq
 * Purpose: DisplayModel is the backend model containing information relevant to UI, such as a palette of colors,
 * background color, and a list of animal shapes. DisplayModel does not require javafx and should function correctly regardless of
 * frontend implementation.
 * Assumptions: colorList is assumed to not be null.
 * Dependencies: ErrorMessage class, ResourceBundles containing information for default colors and default animal shapes
 * How to use: construct a DisplayModel, and it should change when relevant display Commands are executed. When the
 * instance variables of DisplayModel change, the DisplayInterpreter also changes the associated visual components related to the
 * instance variables in DisplayModel.
 */

public class DisplayModel {
    private String backgroundColor;
    private List<String> colorsList;
    private ErrorMessage errorMessage;
    private List<String> animalShapesList;

    /**
     * Constructs a DisplayModel
     * @param error ErrorMessage object used for saving an error to be displayed in frontend DisplayInterpreter
     */
    public DisplayModel(ErrorMessage error){
        makeColorsList();
        makeAnimalShapesList();
        setDefaultBackgroundColor();
        errorMessage = error;
    }

    /**
     * Returns an unmodifiable colorsList, which contains a list of colors. Used by PenQuery Command to find the index
     * of the Animal's pen color
     * @return unmodifiable colorsList
     */
    public List<String> getColorsList(){
        return Collections.unmodifiableList(colorsList);
    }

    /**
     * Sets a color to a specified index in colorsList, used by SetPaletteCommand.
     * @param index index to which the color will be set to in colorsList
     * @param hex hex code of the color
     */
    public void setColorListItem(int index, String hex){
        colorsList.set(index, hex);
    }

    /**
     * Returns animalShapesList, which contains a list of the image file names of possible animal shapes.
     * @return animalShapesList
     */
    public List<String> getAnimalShapesList(){
        return animalShapesList;
    }

    private void makeColorsList(){
        colorsList = new ArrayList<>();
        var resource = ResourceBundle.getBundle("resources/default_visual_items/DefaultColors");
        for (String key: resource.keySet()){
            colorsList.add(resource.getString(key));
        }
    }

    private void makeAnimalShapesList(){
        animalShapesList = new ArrayList<>();
        var resource = ResourceBundle.getBundle("resources/default_visual_items/DefaultAnimalShapes");
        for (String key: resource.keySet()){
            animalShapesList.add(resource.getString(key));
        }
    }

    private void setDefaultBackgroundColor(){
        backgroundColor = colorsList.get(0);
    }

    /**
     *
     * @param index index of desired color
     * @throws NullPointerException throws exception if desired index is out of bounds for the colorsList
     */
    public void setBackgroundColor (int index) throws NullPointerException{
        if (index < colorsList.size()){
            backgroundColor = colorsList.get(index);
        }
        else {
            errorMessage.addError("IndexOutOfBounds");
        }
    }

    /**
     *
     * @param index index of desired color
     * @return String name of color at specified index.
     */
    public String getColor(int index){
        return colorsList.get(index);
    }
}

package interpreters;

import general.DisplayModel;
import general.ErrorMessage;
import interpreters.AnimalInterpreter;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import general.Animal;
import general.SystemStorage;

import java.util.*;

/**
 * @author Irene Qiao isq (visualization extensions, incorporating DisplayModel, use of ResourceBundles, and extensive refactoring), Diego Chamarro (basic)
 *
 * Purpose of DisplayInterpreter: interpret states of the DisplayModel, the backend, and create the appropriate changes in
 * the front-end UI.
 * Assumptions: depends on accuracy of its associated DisplayModel in order to display accurate information to user.
 * Dependencies: DisplayModel and SystemStorage classes from backEnd.general package, javafx packages.
 * How to use: Construct a DisplayInterpreter and call the updateDisplay() method to update UI based on changes in the
 * DisplayModel when a command is executed.
 */
public class DisplayInterpreter {

    private Pane centerScreen;
    private SystemStorage mySystemStorage;
    private ResourceBundle menuResource;
    private ResourceBundle errorMessageResource;
    private DisplayModel myDisplayModel;
    private Menu backgroundMenu;
    private Menu animalMenu;
    private ErrorMessage errorMessage;

    /**
     *
     * @param canvas javafx Pane to which the displayed buttons and menu components are added.
     * @param storage SystemStorage object containing Animal objects
     * @param animalInterpreter AnimalInterpreter that handles javafx/visuals of Animal objects and tracks changes in Animal
     *                          model
     * @param error ErrorMessage object contains list of current errors that require handling/display to user
     * @param height_of_options not used
     */
    public DisplayInterpreter(Pane canvas, SystemStorage storage, AnimalInterpreter animalInterpreter, ErrorMessage error, double height_of_options) {
        mySystemStorage = storage;
        centerScreen = canvas;
        menuResource = ResourceBundle.getBundle("resources/menu_names/MenuNames");
        errorMessage = error;
        myDisplayModel = storage.getDisplay();
        errorMessageResource = ResourceBundle.getBundle("ErrorMessages");
        makeBackgroundMenu();
        makeAnimalMenu();
        centerScreen.getChildren().addAll(setUpOptionBoxes());
        //options.getMenus().addAll(backgroundMenu, animalMenu);
        //options.setPrefHeight(height_of_options);
    }

    /**
     * Updates the background colors menu (when a SetBackgroundCommand is executed) and checks ErrorMessage object for new
     * errors that need to be displayed.
     */
    public void updateDisplay(){
        makeBackgroundMenu();
        setErrorDisplay();
    }

    private Collection<HBox> setUpOptionBoxes(){
        Collection<HBox> optionBoxes = new ArrayList<>();
        HBox colorOptions = new HBox();
        HBox shapeOptions = new HBox();
        optionBoxes.add(colorOptions);
        optionBoxes.add(shapeOptions);
        return optionBoxes;
    }

    private void makeBackgroundMenu() {
        backgroundMenu = new Menu(menuResource.getString("ChooseColor"));
        ToggleGroup group = new ToggleGroup();
        for (String listColor: myDisplayModel.getColorsList()){
            RadioMenuItem color = new RadioMenuItem(listColor);
            color.setOnAction(e->setBackground(listColor));
            color.setToggleGroup(group);
            color.setSelected(true);
            backgroundMenu.getItems().add(color);
        }
    }

    private void makeAnimalMenu(){
        animalMenu = new Menu(menuResource.getString("ChooseAnimalType"));
        ToggleGroup group = new ToggleGroup();
        for (String imageFile: myDisplayModel.getAnimalShapesList()){
            RadioMenuItem shape = new RadioMenuItem(imageFile);
            shape.setOnAction(e->setAnimal(imageFile));
            shape.setToggleGroup(group);
            shape.setSelected(true);
            animalMenu.getItems().add(shape);
        }
    }

    private void setAnimal(String animal) {
        Set<String> animal_names = mySystemStorage.getAnimalNames();
        for (String name : animal_names) {
            Animal active_animal = mySystemStorage.getAnimal(name);
            active_animal.setImage(animal);
        }
    }

    private void setBackground(String color) {
        String style = String.format("-fx-background-color: %s;", color);
        centerScreen.setStyle(style);
    }


    private void setErrorDisplay(){
        if (errorMessage.getErrorsList().size() > 0){
            for (String error: errorMessage.getErrorsList()){
                String message = errorMessageResource.getString(error);
                makeAlertBox(message);
                errorMessage.removeError(error);
            }
        }
    }

    private void makeAlertBox(String message){
        Alert alertBox = new Alert(Alert.AlertType.ERROR);
        alertBox.setTitle(errorMessageResource.getString("AlertBoxTitle"));
        alertBox.setContentText(message);
        alertBox.showAndWait();
    }

    /*public MenuBar getOptions() {
        return options;
    }
     */
}

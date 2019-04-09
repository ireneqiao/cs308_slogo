package general;

import operations.Command;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

/**
 * @author Irene Qiao isq
 * Purpose: Stores variables related to Animal, UI, Commands, and variables. Contains getter and setter methods for these
 * instance variables.
 * Assumptions: does not have error handling implemented so access to variables may result in null pointer exceptions
 * Dependencies: Command, DisplayModel, Animal classes
 * How to use: create an instance of SystemStorage and access Animal objects, can add Commands to list and access as part of
 * Command history/log. Can set and access stored user variables. Stores DisplayModel.
 */
public class SystemStorage {

    private Map<String, Animal> habitat;
    private Map<String, Double> userVariables;
    private Map<String, List<Command>> myCustomCommands;
    private List<Command> myCommandLog;
    private double height_of_screen;
    private double width_of_screen;
    private List<Entry<String, Animal>> myActiveAnimals;
    private DisplayModel myDisplayModel;

    /**
     * Constructor for SystemStorage
     * @param error ErrorMessage
     */
    public SystemStorage(ErrorMessage error){
        habitat = new HashMap<>();
        userVariables = new HashMap<>();
        myCustomCommands = new HashMap<>();
        myCommandLog = new ArrayList<>();
        myActiveAnimals = new ArrayList<>();
        myDisplayModel=new DisplayModel(error);
    }

    /**
     * Sets screen parameters to use to specify Pane constructor parameters, use in DisplayInterpreter
     * @param height double height of screen
     * @param width double width of screen
     */
    public void setScreenParameters(double height, double width){
        height_of_screen = height;
        width_of_screen = width;
    }

    /**
     * Returns habitat map of Animal ID and associated Animal object.
     * @return Map of key String ID with value Animal associated with the ID.
     */
    public Map<String, Animal> getAnimals(){
        return habitat;
    }

    /**
     * Updates list myActiveAnimals with active animals list from parameter.
     * @param activeList list of active Animals
     */
    public void setActiveAnimals(List<String> activeList){
        myActiveAnimals.clear();
        for(String animalID: activeList){
            myActiveAnimals.add(new SimpleEntry(animalID, getAnimal(animalID)));
        }
    }

    /**
     * Returns the DisplayModel
     * @return Displaymodel myDisplayModel
     */
    public DisplayModel getDisplay(){
        return myDisplayModel;
    }

    /**
     * Returns myActiveAnimals, a list of Entries of String ID and associated Animal
     * @return myActiveAnimals
     */
    public List<Entry<String, Animal>> getActiveAnimals(){
        return myActiveAnimals;
    }

    /**
     * Returns set of Strings of Animal IDs
     * @return set of Strings of Animal IDs
     */
    public Set<String> getAnimalNames(){
        HashSet<String> names = new HashSet<>();
        for (String name: habitat.keySet()){
            names.add(name);
        }
        return names;
    }

    /**
     * Returns userVariables, a map of variable names to variable value
     * @return userVariables
     */
    public Map<String, Double> getVariableMap(){
        return userVariables;
    }

    /**
     * Returns set of variable names in userVariables list
     * @return set of variable names
     */
    public Set<String> getVariableNames(){
        HashSet<String> names = new HashSet<>();
        for (String name: userVariables.keySet()){
            names.add(name);
        }
        return names;
    }

    /**
     * Returns Animal when given String ID
     * @param animalID ID of desired Animal to be retrieved
     * @return Animal with parameter ID
     */
    public Animal getAnimal(String animalID){
        if(!habitat.containsKey(animalID)){
            Animal temp = new Animal(animalID, height_of_screen, width_of_screen);
            habitat.put(animalID, temp);
        }
        return habitat.get(animalID);
    }

    /**
     * Returns value of given String variable name
     * @param variable name of variable
     * @return double value of variable of the same name
     */
    public double getVariableValue (String variable){
        if (!userVariables.keySet().contains(variable)){
            setVariableValue(variable, 0);
        }
        return userVariables.get(variable);
        }

    /**
     * Sets variable value to item of the parameter variable name in userVariables list.
     * @param variableName name of desired variable to have value set
     * @param value double value to which the named variable will be set
     */
    public void setVariableValue(String variableName, double value){
        userVariables.putIfAbsent(variableName, value);
        if (userVariables.keySet().contains(variableName)){
            userVariables.put(variableName, value);
        }
    }

    /**
     * Adds a Command to myCommandLog list
     * @param command Command added to myCommandLog list
     */
    public void addToHistory(Command command){
        myCommandLog.add(command);
    }

    /**
     * Returns List of Commands myCommandLog that contains history of Commands
     * @return myCommandLog list of Commands
     */
    public List<Command> getMyCommandLog() {
        return myCommandLog;
    }

}

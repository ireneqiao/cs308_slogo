package general;

import java.util.*;

/**
 * @author Irene Qiao isq
 * Purpose: Handle errors thrown in backend and passing to frontend to display to user in user-friendly manner, keeping
 * back and front independent.
 * Assumptions: Only works for errors that are handled, many errors are left unhandled and may appear as runtime exceptions.
 * Dependencies: none
 * How to use: Construct an ErorrMessage object, call addError in backend to add an error to List errors, detect errors in List
 * in front end and display appropriate error box to user for each error in errors List.
 */
public class ErrorMessage {
    private List<String> errors;

    /**
     * Constructor for ErrorMessage object.
     */
    public ErrorMessage(){
        errors = new ArrayList<>();
    }

    /**
     * Adds key name associated to an error message to List errors
     * @param key String key for error message, from ErrorMessages ResourceBundle
     */
    public void addError(String key){
        errors.add(key);
    }

    /**
     * Returns unmodifiable list of errors, used by DisplayInterpreter to display appropriate error messages to user.
     * @return unmodifiable list of errors
     */
    public List<String> getErrorsList(){
        return Collections.unmodifiableList(errors);
    }

    /**
     * Removes an error from errors List when error is appropriately handled and displayed by DisplayInterpreter
     * @param error
     */
    public void removeError(String error){
        errors.remove(error);
    }
}

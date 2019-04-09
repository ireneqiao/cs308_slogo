CompSci 308: Parser Project Analysis, by Irene Qiao
===================

> This is the link to the [assignment](http://www.cs.duke.edu/courses/compsci308/current/assign/03_parser/):


Design Review
=======

### Overall Design
#### High Level Design
##### Back-end
* OperationBuilder
    * After parsing user input for syntax, OperationBuilder uses recursion to simplify
    operations with nested arguments. OperationBuilder then sets the simplified arguments to each
    Operation object. If the Operation is a only an Operation, then only evaluate is called. If it is 
    also a Command, then execute() will be called.
* controlStructures
    * Includes control structures such as DoTimes, For, conditionals, and other loops. Also
    contains frameworks that handle multiple turtle commands. 
    * When ProgramParser parses the user input text and detects keywords for a ControlStructure,
    that ControlStructure is created and handles the simplification of arguments and the order/number of times
    that an Operation or Command is evaluated or executed.
* Data (resources root)
    * Contains example program files
    * resources package contains resource files for default visual items (color and shape names and corresponding
    color and image files), languages, menu button names/text for UI components, and names of Operation classes corresponding
    to user input keywords (used in ProgramParser, use reflection to get Operation class object from class name in file)
    * Contains ErrorMessages properties file for error messages corresponding to error types, accessed by DisplayInterpreter to
    display appropriate error message to user based on keyword of error type
* General
    * Animal class is the model of the animal, containing position, heading, shape, and pen properties of the animal,
    as well as methods that modify these states. 
    * DisplayModel is the model for the UI, contains information about background color, color palette, and relevant methods
    for changing these states.
    * ErrorMessage contains an error list that is accessible by the DisplayInterpreter and backend classes. When an area occurs,
    the corresponding keyword is added to the list. The DisplayInterpreter detects whether there are errors to handle in the list and
    displays the appropriate error message to the user by finding the corresponding message to the error keyword.
    * ProgramParser reads from regex files to detect if syntax is valid. It also detects variables, control structures, and Operation
    keywords and instantiates the appropriate ControlStructures and Operations, the latter using reflection from the OperatonDefaults 
    properties file.
    * SystemStorage contains the DisplayModel, a map of Animals and each of their IDs, a log of historical commands, user defined variables,
    and setter and getter methods for these collections.
* Operations
    * Contains different types of Operations. All Operations can perform evaluate(), which returns some double value. 
    * Contains the Command interface and Operations that implement Command. All Commands can perform execute(), which changes
    the state of something, such as an Animal or the DisplayModel

##### Front-end
* Interpreters
    * AnimalInterpreter - updates visual component of each Animal based on changes in the Animal model.
    * DisplayInterpreter - updates visual components of the display, such as the background color or palette, based on changes
    in the DisplayModel.
* mainpackage
    * Contains the main class that instantiates interpreters, builders, parser, ErrorMessage, and Console.  
* visualization
    * Not used.
   
#### Adding a New Command
* Create a new subclass extending Operation and implementing the Command interface.
* Add user input keywords associated with the new command into the OperationDefaults
properties file, along with the name of the class.

#### Adding a New Compound to the Front End
* Must create compound within DisplayInterpreter. 
* If compound can be interactive with backend, must also create corresponding backend 
for the compound in DisplayModel.

#### Adding a Feature: Additional Views of a Turtle
* Must create view within DisplayInterpreter with fields for states of the turtle and detect changes in DisplayModel
* DisplayModel must access these states of the turtle and update accordingly
     
#### Dependencies: Easy to Find
* Classes that depend on classes from other modules gain access to these classes by having them passed
through the parameters of the class constructor. For example, the SystemStorage is accessible by the DisplayInterpreter 
because it is passed in through the constructor of the DisplayInterpreter.

#### Other APIs
* The ControlStructures API is confusing. The method names can be misleading and do not give a good idea of what is actually happening within the method, 
which makes them easy to misuse. 
For example, evaluateOrExecute() does not return a boolean that tells the user whether the parsing is at the 
evaluate or execute stage. Instead, it performs 2 other tasks: it returns the return value as a result of calling evaluate() on the Operation passed through 
its parameter and calls execute() on a Command if it is at the "execute" stage.
* The protected methods in ControlStructures also contains duplicated code (Ex: findIndexOfEndBracket, replaceCodeWithReturnValue)
* Names and methods are often long.
* Encapsulation: To some extent, the code is encapsulated because the subclasses that extend ControlStructure use many protected methods, so 
if a change needed to be made in implementation, a change in the implementation of a protected method in the superclass would create the
change in the subclasses. Subclasses of ControlStructure also override methods from the superclass, thus implementation is flexible in subclasses.
* What I learned: Method and variable names are very important in writing readable code. The names of methods and variables tend to be very long. 
While these names can be descriptive, they create long lines of code where the methods are called, or when variables are used. Since there is so much
duplicated code, there could easily be smaller methods created that would 1. break up the longer methods and 2. get rid of duplication so that any
changes made to the implementation of the duplicated action would appear everywhere the action is performed.
* The total code is generally inconsistent in style. My method names tend to be very short and my methods tend to be sparse. Daniel's code tends to have longer
methods and longer names. I also read from resource files frequently while Diego's code for AnimalScreen previously (before I refactored it) included menu buttons and
colors with hardcoded names/actions. Daniel's code in the ProgramParser also hardcoded the addition of ControlStructures to a map instead
of using reflection and reading from a resource file of ControlStructure names.

### Your Design
#### High Level Design
##### Operations
* Operations is an abstract superclass from which all of the commands/queries extend. 
* All Operations take some number of arguments, contain an array of arguments, and implement evaluate(), which
makes some calculation or returns some information based its the arguments. 
* Operations also contain a boolean for whether it can handle unlimited arguments, which is useful in 
implementing the grouping feature (Ex: (sum 10 20 20 30) works).
* Operations contains setter methods for the number of arguments (set by specific subclasses of Operations) and 
the array of arguments (set by OperationBuilder after parsing and simplifying arguments)
* Example subclasses:
    * BooleanOperation abstract superclass: sets number of arguments to 2, contains information about double value that
    represents true and value that represents false as well as a method that determines return value based
    on the boolean that is calculated by each specific subclass implementaiton.
    * TurtleOperation abstract superclass: An Operation that acts on an Animal, contains an Animal 
    instance variable, getter method for Animal, setter method for setting specific Animal to be acted upon/queried, 
    used by OperationBuilder.
* Command Interface - all Commands must implement execute(), which creates a change in the state of an object, 
such as an assigned Animal or the DisplayModel.
    * This Command Interface is separate from Operations because Operations contains information
    about access to instance variables, such as Animals. Some Operations, such as HeadingQuery and SetHeadingCommand,
    both require access to an Animal. However, only SetHeadingCommand creates any changes - HeadingQuery would not
    require an implementation of execute(). To deal with this, I used an interface because a class can extend from one superclass. 
    Without an interface for Command, I would have had to create additional superclasses to differentiate between Operations that
    required an Animal (or some other instance variable) and did not execute() and those that did execute().
    * Using the Command Interface also simplifies code by allowing execute() to be called on all Operations that implement Command
    instead of using many conditionals to identify the Command subclasses of different Operations superclasses.

##### DisplayModel and DisplayInterpreter
* DisplayModel is a backend model of the display and contains information about the palette of colors and 
background color of the model.
* DisplayInterpreter has access to states of the DisplayModel and updates the javafx components according to changes
in the DisplayModel.

##### SystemStorage
* SystemStorage contains many getter methods for getting the Animals and DisplayModel.
* SystemStorage has a getUserVariables() method used by ProgramParser to get variables and variable values, or 
create a new variable if the name doesn't exist.
* SystemStorage is used by SystemStorageOperations to get the DisplayModel, or used to get the map of 
Animals in order to find the total number of Animals for the NumTurtles Operation.

##### ErrorMessage
* ErrorMessage method addError() is called in the backend when an error is encountered. This adds the error keyword to a list.
* DisplayInterpreter calls getErrorsList() and if the list contains any errors, then the DisplayInterpreter will find the corresponding
error message to the keyword from a resources file and display the message to the user. After displaying the error, DisplayInterpreter
calls removeError() to remove the error from the list of errors to handle
* ErrorMessage is supposed to allow errors to be handled in the frontend using javafx and keeping the rest of the backend separate.

#### Design Checklist Issues
* Communication: I think that there are no issues in this category. I use meaningful names, use constants instead of magic values,
do not need comments for readable code, declare variables in appropriate scope, write concisely, and have no warnings.
* Modularity: The SystemStorage class is not active - it only contains setter and getter methods. Getter methods also return too much 
information. For example, getDisplayModel() simply returns the entire DisplayModel object and access to all of its methods instead of 
only certain information. Setter methods also do not validate data received.
* Flexibility: No obvious issues in this category.

#### A Good Feature:
* Creating a Command interface design problems: 
    * Some Operations needed access to a Turtle, but not all of these Operations performed an action. 
    For example, some TurtleOperations were queries and only needed to return a value, while others needed
    to act on the Turtle as well as return some value.
    * In OperationBuilder, when simplifying the arguments of an Operation, to get the return value of an Operation
    required calling the execute() method of the Operation. However, this meant that getting the return value would
    result in a change in some state even before the entire user input expression was determined to be valid. There needed
    to be separate methods, one for returning a value and one for executing an action. If all Operations contained both
    methods, then many Operations, such as queries, would have empty execute() method implementations.
* Solution:
    * Using an interface allows a subclass to extend from an Operation superclass and also implement the Command interface.
    This reduces the number of abstract superclasses to be created.
    * Using the Command interface allows execute() to be called only on Operations that implement the interface, so that queries
    would not need to implement the method. evaluate() is implemented by all Operations since all Operations return some double
    value.
* Assumptions/Dependencies:
    * Dependencies exist in some Operation superclasses but not related to the Command interface directly.
    For example, the SystemStorageOperation depends on the SystemStorage class.
    
#### A Bad Feature:
* SystemStorage class design problems:
    * Initially, SystemStorage was meant to serve as the storage for Animals, Commands, and user defined variables.
    However, as the project, more and more miscellaneous objects were added as instance variables to be stored in this class,
    such as DisplayModel.
    * Many classes require access to SystemStorage because it contains instance variables relevant to nearly every part
    of the project. However, this means that each class that has access to the SystemStorage also has access to many unrelated
    instance variables. For example, a DisplayOperation has access to the SystemStorage because it needs access to the DisplayModel,
    but by having the SystemStorage it could also call methods to get variables, which is completely unrelated to DisplayOperation.
    * Instead of containing instance variables for so many different types of objects, I should have created a controller
    class for each of these objects to act as an in-between for the backend and front end models/interpreters so that access to
    a model would not allow access to unrelated models. 
* Dependencies: many dependencies - since it contains Animals, Operations, and a DisplayModel, for example, the SystemStorage depends on 
    the Animal, Operation, and DisplayModel classes.
    
### Flexibilty
* I think that the Operations superclass (and abstract subclasses) and ControlStructures makes the project flexible
by implementing polymorphism and allowing easier implementation of addition Operations or ControlStructures in the future.

#### Feature 1: ProgramParser
* This code is interesting because it involves reading from regex files, which I have never used before.
* It requires SystemStorage to construct ControlStructures and parse user defined variables for values.
* It requires access to a language resource file, but not directly. The name of the language syntax resource file
is passed in through a public method that is called on ProgramParser in the Main class.
* There are many hardcoded parts in this class:
    * Adding a ControlStructure would require changing code within this class, where each ControlStructure is individually
    added to a map of ControlStructures
    * Variables are detected by the ":" before each variable name. If this syntax were to change
    we would need to change the code in this class that detects the symbol, instead of only altering
    a resource file containing symbols to detect variables.
    * Changing the syntax used to detect variable types would be difficult/unnecessarily complicated to change.

#### Feature 2: AnimalModel
* This code is interesting because it not only contains backend information about the Animal, but also the pen of the Animal, 
all in one class.
* Dependencies: none
* Design: This class is rather long and should instead be split into an AnimalModel and PenModel class. 
By keeping pen information within the Animal class, Commands modifying pen information are limited in flexibility.
If they were separate, it would be easier to create Commands that change the pen information uniformly across different Animals, 
or alter pen information separately for each Animal without having unncessary access to information about the Animal's position or
heading, which is unrelated to the pen but is currently accessible because the pen is part of the Animal.
* Adding features to the Animal requires changing the code within the AnimalModel as well as in the AnimalInterpreter.
However, in terms of visualization, the implementation of visualization, such as the image files used to represent the AnimalModel,
is independent of the backend. 

### Alternate Designs
#### Original Design
* The original design did not have any separation between backend models and frontend implementations. For example,
there was no Animal model and interpreter, there was only Animal, which meant that changing javafx implementation would
involve making coding changes in the same class containing backend information. Same situation applied to the display.
* The original design did not contain any modules. Everything was in one module. This was bad because all classes had access to
other classes, related or not.

#### Design Decision 1: 
* Separating all classes into either Backend or Frontend Module
* Alternate design: Model, Controller, and View Modules
* I think that using 3 modules instead would have made more sense because the front end isn't 
entirely independent from the backend module - the interpreter classes directly use the backend classes.
* Using only 2 modules was the final decision because we couldn't figure out how to get rid of circular dependencies
when using 3 modules.
* I would prefer using 3 modules but I needed more time to figure out how to manage the dependencies.



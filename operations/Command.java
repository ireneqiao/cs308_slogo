package operations;

/**
 * @author Irene Qiao isq
 * Purpose: All objects that implement the Command interface can be called to execute. This method can be overriden so that
 * each Command performs a unique action when execute() is called. This interface is important to distinguish Command objects
 * from objects that are only Operations and do not need to execute, only evaluate. Use of interface allows more flexible inheritance
 * instead of creating more inheritance hierarchies from which to exend.
 * Assumptions: n/a
 * Dependencies: n/a
 * How to use: implement Command interface and implement execute() as appropriate.
 */
 public interface Command {
    /**
     * This method is called for a Command to perform its special action, implementation may vary greatly.
     */
    void execute();
}

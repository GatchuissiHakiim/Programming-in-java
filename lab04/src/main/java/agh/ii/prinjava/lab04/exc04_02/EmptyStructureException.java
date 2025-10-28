package agh.ii.prinjava.lab04.exc04_02;

/**
 * Exception thrown when an operation is attempted on an empty data structure.
 */
public class EmptyStructureException extends Exception {
    public EmptyStructureException() {
        super();
    }

    public EmptyStructureException(String message) {
        super(message);
    }
}

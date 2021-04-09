/*
 * EmptyQueueException.java
 *
 *
 * Thrown when trying to remove from an empty queue
 */

/**
 *
 * @author Shay Tavor, shay.tavor@gmail.com
 */
public class EmptyQueueException extends Exception {
    
    public EmptyQueueException(String msg) {
        super(msg);
    }
    
}

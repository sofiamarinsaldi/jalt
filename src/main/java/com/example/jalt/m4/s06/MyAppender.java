/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m4.s06;

/**
 * Currently waiting for its design to be finalized
 * 
 * @see MyLogger
 */
public interface MyAppender {
    /**
     * Append a message in the log
     * 
     * @param message the message to be logged
     */
    public void append(String message);
}

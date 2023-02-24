/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s06;

/**
 * Currently waiting for its design to be finalized
 * 
 * @see MyLogger
 */
public interface MyFormatter {
    /**
     * Prepare a message for logging
     * 
     * @param severity the log severity
     * @param message  the message, as passed by the caller
     * @return the formatted message
     */
    public String format(MySeverity severity, String message);
}

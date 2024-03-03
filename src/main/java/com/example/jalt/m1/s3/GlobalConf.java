/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m1.s3;

import java.util.logging.Logger;

/**
 * Logging example, using global JUL configuration
 */
public class GlobalConf {
    /** The global JUL logger is very simple to use */
    private static final Logger log = Logger.getGlobal();

    /**
     * Log a few messages
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        System.out.println("This is a message to the user: hello!");

        // By default, the lowest logging levels are disabled
        log.finest("finest logging message");
        log.finer("finer logging message");
        log.fine("fine logging message");
        log.config("config logging message");
        // By default, only the following levels are active
        log.info("info logging message");
        log.warning("warning logging message");
        log.severe("severe logging message");
    }
}

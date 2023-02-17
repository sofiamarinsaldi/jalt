/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m1.s3;

import java.util.logging.Logger;

/**
 * Another class to see JUL at work
 */
public class Other {
    /** Notice that JUL asks the name of the logger */
    private static final Logger log = Logger.getLogger(Other.class.getName());

    /**
     * Print to system out (for the user), then log a few message with different severity (for developers)
     */
    public void f() {
        System.out.println("Message to user: I'm in another class!");

        log.finest("finest logging message");
        log.finer("finer logging message");
        log.fine("fine logging message");
        log.config("config logging message");
        log.info("info logging message");
        log.warning("warning logging message");
        log.severe("severe logging message");
    }
}

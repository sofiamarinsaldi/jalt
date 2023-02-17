/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m1.s2;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * A class using
 * <li>System.out to generate user output
 * <li>JUL with default settings to generate logging
 */
public class Hello {
    /** A JUL logger */
    private static final Logger log = Logger.getLogger(Hello.class.getName());

    public static void main(String[] args) {
        // This message is meant to be seen by developers
        log.info("User input by args: " + Arrays.toString(args));

        if (args.length == 0 || args[0].isBlank()) {
            // These message is meant to be seen by users
            System.out.println("Please, pass me your name");
        } else {
            System.out.println("Hello, " + args[0]);
        }

        // This message is meant to be seen by developers
        log.info("Done");
    }

    /**
     * Saying hello
     * 
     * @param user name to greet - precondition, a non-empty string is expected
     */
    public static void greet(String user) {
        // This message is meant to be seen by developers (not normally)
        log.finest("User is " + user);
        // These message is meant to be seen by users
        System.out.println("Hello, " + user);
    }
}

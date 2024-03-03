/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m1.s1;

import java.util.Arrays;

/**
 * A class using
 * <li>System.out to generate user output
 * <li>System.err to generate logging
 */
public class Hello {
    /**
     * Show the difference between user output and logging
     * 
     * @param args the caller is expected to pass own name as first argument
     */
    public static void main(String[] args) {
        // This message is meant to be seen by developers
        System.err.println("In main() args is " + Arrays.toString(args));

        if (args.length == 0 || args[0].isBlank()) {
            // This message is meant to be seen by users
            System.out.println("Please, pass me your name");
        } else {
            greet(args[0]);
        }

        // This message is meant to be seen by developers
        System.err.println("Done main()");
    }

    /**
     * Saying hello
     * 
     * @param user name to greet - precondition, a non-empty string is expected
     */
    public static void greet(String user) {
        // This message is meant to be seen by developers
        System.err.println("In greet() user is " + user);
        // This message is meant to be seen by users
        System.out.println("Hello, " + user);

        // This message is meant to be seen by developers
        System.err.println("Done greet()");
    }
}

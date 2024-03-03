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
        System.err.println("User input by args: " + Arrays.toString(args));

        // These messages are meant to be seen by users
        if (args.length == 0) {
            System.out.println("Please, pass me your name");
        } else {
            System.out.println("Hello, " + args[0]);
        }

        // This message is meant to be seen by developers
        System.err.println("Done");
    }
}

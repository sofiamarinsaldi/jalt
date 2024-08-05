/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s2;

/**
 * A simple class to experiment with Jupiter assertions when an exception could occur
 * 
 * @see SimpleTest, its JUnit test case
 */
public class Simple {
    /**
     * Negate the input value
     * 
     * @param value
     * @return the negated input
     * @throws IllegalArgumentException when it is not possible to negate correctly the input value
     */
    public int negate(int value) {
        if (value == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Can't negate MIN_VALUE");
        }
        return -value;
    }
}

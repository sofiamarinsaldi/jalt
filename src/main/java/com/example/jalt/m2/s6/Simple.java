/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s6;

/**
 * A simple class providing methods to experiment with Jupiter assertions
 * 
 * @see SimpleTest, its JUnit test case
 */
public class Simple {
    /**
     * Negate the input value.
     * 
     * For instance, if the caller pass 42, then -42 should be returned.
     * 
     * @param value the input
     * @return the negated value
     */
    public int negate(int value) {
        return -value;
    }

    /**
     * Check if the input is positive
     * 
     * @param value a number
     * @return true if the passed value is greater than zero
     */
    public boolean isPositive(int value) {
        return value > 0;
    }

    /**
     * String generator, for non-positive values
     * 
     * @param value a number
     * @return null if the value is greater than zero
     */
    public String nullIfPositive(int value) {
        return value > 0 ? null : "not a null";
    }

    /**
     * Multiplier
     * 
     * @param left  a first value
     * @param right a second value
     * @return the product of the two input values
     */
    public double multiply(double left, double right) {
        return left * right;
    }
}

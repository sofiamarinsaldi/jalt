/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s5;

/**
 * A first implementation, following the test case.
 * 
 * @see SimpleTest, its JUnit test case
 */
public class Simple {
    /**
     * Negate the input value.
     * <p>
     * For instance, if the caller pass 42, then -42 should be returned.
     * 
     * @param value the input
     * @return the negated value
     */
    public int negate(int value) {
        return -value;
    }
}

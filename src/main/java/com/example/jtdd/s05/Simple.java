/*
 * Introduction to Test Driven Development with Java
 * 
 * https://github.com/egalli64/jtdd
 */
package com.example.jtdd.s05;

/**
 * A first implementation, following the test case.
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
}

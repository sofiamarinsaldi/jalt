/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * A test case with a couple of tests in it
 * 
 * @see Simple, the class to be tested
 */
class SimpleTest2 {
    /**
     * Each test in this case work on an object created in the same way. There is no
     * need of a specific definition for each one, just put it at class level.
     */
    private Simple simple = new Simple();

    /**
     * Test for positive input
     */
    @Test
    public void negatePositive() {
        int input = 42;

        int expected = -42;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }

    /**
     * Test for negative input
     */
    @Test
    public void negateNegative() {
        int input = -42;

        int expected = 42;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }
}

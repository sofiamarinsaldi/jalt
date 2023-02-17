/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * A test case with a first actual test in it
 * 
 * @see Simple, the class to be tested
 */
class SimpleTest {
    /**
     * The test is named as the tested method, plus a hint on its raison d'être.
     */
    @Test
    public void negatePositive() {
        Simple simple = new Simple();
        int input = 42;

        int expected = -42;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }
}

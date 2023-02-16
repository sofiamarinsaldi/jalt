/*
 * Introduction to Test Driven Development with Java
 * 
 * https://github.com/egalli64/jtdd
 */
package com.example.jtdd.s05;

import static org.junit.jupiter.api.Assertions.*;

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

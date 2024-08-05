/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * A test case with a first actual test in it
 * 
 * @see Simple, the class to be tested
 */
class SimpleTest {
    /**
     * Test named from the tested method, plus info following BDD
     * <ul>
     * <li>Given: nothing special, Simple is created
     * <li>When: a positive value is passed
     * <li>Then: the negate value passed in is expected
     */
    @Test
    public void negateWhenPositiveThenNegative() {
        Simple simple = new Simple();
        int input = 42;

        int expected = -42;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }
}
